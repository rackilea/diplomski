SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
Schema compiledSchema = schemaFactory.newSchema(new SOTests().getClass()
    .getClassLoader().getResource("generalInvoiceRequest_430.xsd"));
Validator validator = compiledSchema.newValidator();
try {
    validator.validate(new StreamSource("D:\\...\\dentist_ersred_TG_430.xml"));
    System.out.println("Valid.");
}
catch (SAXException ex) {
    System.out.print("Not valid because..." + ex.getMessage());
}