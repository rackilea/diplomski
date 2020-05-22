class AddressAdapter extends TypeAdapter<Address> {
    @Override
    public void write(JsonWriter out, Address address) throws IOException {
        if (address == null) {
            //if the writer was not allowed to write null values
            //do it only for this field
            if (!out.getSerializeNulls()) {
                out.setSerializeNulls(true);
                out.nullValue();
                out.setSerializeNulls(false);
            } else {
                out.nullValue();
            }
        } else {
            out.beginObject();
            out.name("country");
            out.value(address.country);
            out.name("city");
            out.value(address.city);
            out.endObject();
        }
    }

    @Override
    public Address read(JsonReader in) throws IOException {
        if(in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        in.beginObject();
        Address address = new Address();
        in.nextName();
        address.country = in.nextString();
        in.nextName();
        address.city = in.nextString();
        in.endObject();
        return address;
    }
}