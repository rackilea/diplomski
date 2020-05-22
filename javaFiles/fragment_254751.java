StreamResult result = new StreamResult(new File("output.html"));
StreamSource source = new StreamSource(new File("report.xml"));
StreamSource xslt = new StreamSource(new File("transform.xslt"));

Transformer transformer = TransformerFactory.newInstance().newTransformer(xslt);

transformer.transform(source, result);