public abstract class BaseGsonSerializer extends TypeSerializer {

    private Gson gson;

    public BaseGsonSerializer() {
        this.gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @DebugLog
    @Override
    public Class<?> getSerializedType() {
        return String.class;
    }

    @Override
    @DebugLog
    public Class<?> getDeserializedType() {
        return TypeToken.get(getTypeDeserialize()).getRawType();
    }

    @Override
    public Object serialize(Object data) {
        if (data != null) {
            return gson.toJson(data);
        }
        return null;
    }

    @Override
    public Object deserialize(Object data) {
        if (data != null) {
            return gson.fromJson(data.toString(), getTypeDeserialize());
        }
        return null;
    }

    protected abstract Type getTypeDeserialize();

}