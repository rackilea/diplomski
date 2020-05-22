TransformerFactory factory = TransformerFactory.newInstance();
Source xslt = new StreamSource(new File("Split.xslt"));
Transformer transformer = factory.newTransformer(xslt);

Source text = new StreamSource(new File("File1.xml"));
transformer.transform(text, new StreamResult(new File("File2.xml")));