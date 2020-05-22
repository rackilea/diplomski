TransformerFactory factory = TransformerFactory.newInstance();
Transformer transformer = factory.newTransformer();

DOMSource source = new DOMSource(doc);
StreamResult result = new StreamResult(new File("/sdcard/sample.xml"));
transformer.transform(source, result);