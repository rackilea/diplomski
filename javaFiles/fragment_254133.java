public static void write(String stylesheetText, Map<String, ?> input, OutputStream output) {
    StringBuilder xml = new StringBuilder();
    xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n");
    xml.append("<data>");
    for(Map.Entry<String, ?> entry: input.entrySet()) {
        field(xml, entry.getKey(), entry.getValue());
    }
    xml.append("</data>");
    FopFactory fopFactory = FopFactory.newInstance();
    FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
    try {
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource source = new StreamSource(new StringReader(stylesheetText));
        Transformer transformer = factory.newTransformer(source);
        transformer.setParameter("versionParam", "2.0");
        Source s = new StreamSource(new StringReader(xml.toString()));
        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, output);
        Result result = new SAXResult(fop.getDefaultHandler());
        transformer.transform(s, result);
        output.close();
    } catch (IOException exception) {
        throw new PdfException(exception);
    } catch (TransformerException exception) {
        throw new PdfException(exception);
    } catch (TransformerFactoryConfigurationError exception) {
        throw new PdfException(exception);
    } catch (FOPException exception) {
        throw new PdfException(exception);
    }
}