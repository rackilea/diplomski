Document inputDoc = ((Element) doc.getContent().get(0)).getOwnerDocument();
String inputPayload = "";
StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(new DOMSource(inputDoc), new StreamResult(sw));
            inputPayload = sw.toString();
            System.out.println("Read the input stream successfully "+ inputPayload);