public class MyTypeAdapter extends TypeAdapter<BigNestedClass> {

    private Gson gson = new Gson();

    @Override
    public BigNestedClass read(JsonReader arg0) throws IOException {
        // Get the string value and do kind of nested deserializing to an instance of
        // BigNestedClass
        return gson.fromJson(arg0.nextString(), BigNestedClass.class);
    }

    @Override
    public void write(JsonWriter arg0, BigNestedClass arg1) throws IOException {
        // Get the instance value and insted of normal serializing make the written
        // value to be a string having escaped json
        arg0.value(gson.toJson(arg1));
    }

}