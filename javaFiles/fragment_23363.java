return new StreamingOutput() {
    @Override
    public void write(OutputStream out)
            throws IOException, WebApplicationException {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StreamResult result = new StreamResult(out);
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
};