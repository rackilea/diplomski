DocumentBuilderFactory builder = DocumentBuilderFactory.newInstance();
builder.setNamespaceAware(true);
builder.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
builder.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);


return builder.newDocumentBuilder().parse(
        new InputSource(new StringReader(strDoc)));