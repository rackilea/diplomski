public class Gson {

    private static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        public <T> TypeAdapter<T> create(com.google.gson.Gson gson, TypeToken<T> type) {
            return type.getRawType() == Object.class ? (TypeAdapter<T>) new LongObjectTypeAdapter(gson) : null;
        }
    };



    static {
        try {
            Field field = ObjectTypeAdapter.class.getDeclaredField("FACTORY");

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            field.setAccessible(true);
            field.set(null, FACTORY);

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }



    private com.google.gson.Gson gson = new com.google.gson.Gson();



    public <T> T fromJson(String payload, Class<T> c) {
        return gson.fromJson(payload, c);
    }



    public String toJson(Object object) {
        return gson.toJson(object);
    }



    public static class LongObjectTypeAdapter extends TypeAdapter<Object> {

        private com.google.gson.Gson gson;

        public LongObjectTypeAdapter(com.google.gson.Gson gson) {
            this.gson = gson;
        }

        public Object read(JsonReader in) throws IOException {
            JsonToken token = in.peek();

            switch (token) {
                case BEGIN_ARRAY:
                    ArrayList list = new ArrayList();
                    in.beginArray();

                    while(in.hasNext()) {
                        list.add(this.read(in));
                    }

                    in.endArray();
                    return list;
                case BEGIN_OBJECT:
                    LinkedTreeMap map = new LinkedTreeMap();
                    in.beginObject();

                    while(in.hasNext()) {
                        map.put(in.nextName(), this.read(in));
                    }

                    in.endObject();
                    return map;
                case STRING:
                    return in.nextString();
                case NUMBER:
                    String value = in.nextString();
                    if (value.contains(".")) {
                        return Double.valueOf(value);
                    } else {
                        return Long.valueOf(value);
                    }

                case BOOLEAN:
                    return Boolean.valueOf(in.nextBoolean());
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    throw new IllegalStateException();
            }
        }

        public void write(JsonWriter out, Object value) throws IOException {
            if (value == null) {
                out.nullValue();
            } else {
                TypeAdapter typeAdapter = gson.getAdapter(value.getClass());
                if (typeAdapter instanceof LongObjectTypeAdapter) {
                    out.beginObject();
                    out.endObject();
                } else {
                    typeAdapter.write(out, value);
                }
            }
        }
    }
}