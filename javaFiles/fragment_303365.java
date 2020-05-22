public String prettyHTMLPrint (String html) {  
    if (html==null || html.isEmpty()) {
        throw new RuntimeException("xml null or blank in prettyHTMLPrint()");
    }
    StringWriter sw;
    try {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setSuppressDeclaration(true);
        org.dom4j.Document document = DocumentHelper.parseText(html);
        sw = new StringWriter();
        XMLWriter writer = new XMLWriter(sw, format);
        writer.write(document);
    }
    catch (Exception e) {
        throw new RuntimeException("Error pretty printing html: " + e, e);
    }
    return sw.toString();
}