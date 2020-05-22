public class ATypeAdapterFactory implements TypeAdapterFactory {

    public TypeAdapter<A> create(Gson gson, TypeToken type) {
        if (!A.class.isAssignableFrom(type.getRawType())) {
            // Check if incoming raw type is an instance of A interface
            return null;
        } 

        final TypeAdapter<A> delegate = gson.getDelegateAdapter(this, type);

        return new TypeAdapter<A>() {

            @Override
            public void write(JsonWriter out, A value) throws IOException {
                if(value.isSomeCase()) {
                    // your custom logic here
                    out.beginObject();
                    out.name("x").value(0);
                    out.endObject();
                } else {
                    // default serialization here
                    delegate.write(out, value);
                }
            }

            @Override
            public A read(JsonReader in) throws IOException {
                return delegate.read(in);
            }
        };
    }
}