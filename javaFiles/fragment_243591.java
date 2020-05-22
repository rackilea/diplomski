protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    try {
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xsl = new StreamSource(new File("Alumnos.xsl"));
        Transformer newTransformer = factory.newTransformer(xsl);

        StreamSource xml = new StreamSource(new File("Alumnos.xml"));
        PrintWriter writer = response.getWriter();
        Result result = new StreamResult(writer);
        newTransformer.transform(xml, result);
    } catch (IOException ioe) {
        ioe.printStackTrace();
    } catch (TransformerException te) {
        te.printStackTrace();
    }
}