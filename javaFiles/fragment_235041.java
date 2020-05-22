String extractXml(InputStream in) {
    // IOUtils is a util class from commons-io
    String xml = IOUtils.toString(new XmlStreamReader(in));
    xml=xml.replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim();
    return xml
}