public void generateSchema(final Class<?> classesToBeBound,
                           final OutputStream schemaStream)
    throws JAXBException, IOException {

    final JAXBContext context = JAXBContext.newInstance(classesToBeBound);

    context.generateSchema(new SchemaOutputResolver() {
        public Result createOutput(final String namespaceUri,
                                   final String suggestedFileName)
            throws IOException {

            return new StreamResult(schemaStream) {
                @Override
                public String getSystemId() {
                    return suggestedFileName;
                }
            }
        }
    });
}