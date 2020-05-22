public class MyClassAdapter extends TypeAdapter<MyClass> {
    @Override public void write(JsonWriter out, MyClass myClass) throws IOException {
        // implement the write method
    }
    @Override public MyClass read(JsonReader in) throws IOException {
        // implement the read method
        return ...;
    }
}