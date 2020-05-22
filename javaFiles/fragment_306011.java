Validator validator = factory.newSchema(new StreamSource(
      TestValidation.class.getResourceAsStream("/books2.xsd"))).newValidator();
  try {
     validator.validate(new DOMSource(nodes.item(0)));
     System.out.println("XML is valid.");
  } catch (SAXException ex) {
     System.out.println("XML is not valid because " + ex.getMessage());
  }