public class MyTypeAdapter extends TypeAdapter<TestObject>() {

    @Override
    public void write(JsonWriter out, TestObject value) throws IOException {
        out.beginObject();
        if (!Strings.isNullOrEmpty(value.test1)) {
            out.name("test1");
            out.value(value.test1);
        }

        if (!Strings.isNullOrEmpty(value.test2)) {
            out.name("test2");
            out.value(value.test1);
        }
        /* similar check for otherObject */         
        out.endObject();    
    }

    @Override
    public TestObject read(JsonReader in) throws IOException {
        // do something similar, but the other way around
    }
}