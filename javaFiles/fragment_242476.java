class ConnectionOptionsTypeAdapter extends TypeAdapter<ConnectionOptions> {

    @Override
    public void write(JsonWriter out, ConnectionOptions value)
            throws IOException {
        // implement if you need it
    }

    @Override
    public ConnectionOptions read(JsonReader in) throws IOException {
        final ConnectionOptions connectionOptions = new ConnectionOptions();

        in.beginArray();
        connectionOptions.URL = in.nextString();
        connectionOptions.RESID = in.nextString();
        in.endArray();

        return connectionOptions;
    }
}