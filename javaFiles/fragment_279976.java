StreamingOutput stream = new StreamingOutput() {
    @Override
    public void write(OutputStream os) throws IOException,
    WebApplicationException {
        Writer writer = new BufferedWriter(new OutputStreamWriter(os));

        //@TODO read the file here and write to the writer

        writer.flush();
    }
};

return Response.ok(stream).build();