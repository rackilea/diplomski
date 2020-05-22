private String updateXMLDeductible(String deductible, String xml) {
  MyObject myObject= JAXB.unmarshal(new StringReader(xml), MyObject.class);
  myObject.setDeductible(deductible);
  StringWriter stringWriter = new StringWriter();
  return JAXB.marshal(myObject,stringWriter);
}