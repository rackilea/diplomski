public class ArrayAdapter<T> extends TypeAdapter<List<T>> {
    private Class<T> adapterclass;

    public ArrayAdapter(Class<T> adapterclass) {

        this.adapterclass = adapterclass;
    }

    public List<T> read(JsonReader reader) throws IOException {


        List<T> list = new ArrayList<T>();

        Gson gson = new Gson();

        if (reader.peek() == JsonToken.BEGIN_OBJECT) {

            T inning = (T) gson.fromJson(reader, adapterclass);
            list.add(inning);

        } else if (reader.peek() == JsonToken.BEGIN_ARRAY) {

            reader.beginArray();
            while (reader.hasNext()) {
                T inning = (T) gson.fromJson(reader, adapterclass);
                list.add(inning);
            }
            reader.endArray();

        } else {
            reader.skipValue();
        }

        return list;
    }

    public void write(JsonWriter writer, List<T> value) throws IOException {

    }

}

public class ArrayAdapterFactory implements TypeAdapterFactory {

  @SuppressWarnings({ "unchecked" })
  @Override
  public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> type) {

      ArrayAdapter typeAdapter = null;
      try {
          if (type.getRawType() == List.class)
          {

              typeAdapter = new ArrayAdapter(
                      (Class) ((ParameterizedType) type.getType())
                              .getActualTypeArguments()[0]);
          }
      } catch (Exception e) {
          e.printStackTrace();
      }

      return typeAdapter;
}