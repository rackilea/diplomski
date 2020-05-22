String yourXMLFragment = "...";

AttributeStatementBuilder attributeStatementBuilder = 
   (AttributeStatementBuilder) builderFactory.getBuilder(AttributeStatement.DEFAULT_ELEMENT_NAME);
AttributeStatement attributeStatement = attributeStatementBuilder.buildObject();

AttributeBuilder attributeBuilder = 
   (AttributeBuilder) builderFactory.getBuilder(Attribute.DEFAULT_ELEMENT_NAME);
Attribute attr = attributeBuilder.buildObject();
attr.setName("yourAttributeName");

XSAnyBuilder sb2 = (XSAnyBuilder) builderFactory.getBuilder(XSAny.TYPE_NAME);
XSAny attrAny = sb2.buildObject(AttributeValue.DEFAULT_ELEMENT_NAME, XSAny.TYPE_NAME);
attrAny.setTextContent(yourXMLFragment.trim());

attr.getAttributeValues().add(attrAny);
attributeStatement.getAttributes().add(attr);