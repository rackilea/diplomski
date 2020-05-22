DOMSource domSource = new DOMSource(engine.getDocument());
StreamResult result = new StreamResult(outputFile);
TransformerFactory tf = TransformerFactory.newInstance();
Transformer transformer = tf.newTransformer();
transformer.setOutputProperty(OutputKeys.METHOD, "html");
transformer.transform(domSource, result);