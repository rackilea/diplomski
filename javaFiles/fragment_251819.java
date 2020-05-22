Source xsl = ...
SAXTransformerFactory factory = (SAXTransformerFactory) TransformerFactory.newInstance();
TransformerHandler handler = factory.newTransformerHandler(xsl);

DOMResult result = new DOMResult();

handler.setResult(result);

marshaller.marshal(inputObject, handler);

transformedObject = unmarshaller.unmarshal(result.getNode());