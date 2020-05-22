StreamingOutput entity = new StreamingOutput() {
    @Override
    public void write(OutputStream out)
            throws IOException, WebApplicationException {

        CustomSerializer.serialize(bigObject, out);
    }
};