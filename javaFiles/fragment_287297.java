TransformerFactory tf = TransformerFactory.newInstance();
Transformer transformer = tf.newTransformer();
transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

File file = new File("Path/to/file.xml");
transformer.transform(new DOMSource(doc), new StreamResult(file));

response().setHeader("Content-Disposition", "attachment;filename=" + file.getName());
response().setHeader("Content-Type", "text/xml; charset=ISO-8859-1");
return ok(file).as("text/xml");