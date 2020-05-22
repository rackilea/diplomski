Transformer tf = TransformerFactory.newInstance().newTransformer();
tf.setOutputProperty(OutputKeys.INDENT, "yes");
tf.setOutputProperty(OutputKeys.METHOD, "xml");
tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

DOMSource domSource = new DOMSource(doc);
StreamResult sr = new StreamResult(new File("Data.xml"));
tf.transform(domSource, sr);