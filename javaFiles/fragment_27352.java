MetadataBuilder builder = new MetadataBuilder();
builder.setNamespaces(Arrays.asList(new String[] { "odata" }));
builder.setValidator(validator);

TargetEntityType personDetailsAddressType
        = builder.addTargetComplexType("odata", 
                             "personDetailsAddress");
personDetailsAddressType.addField("street", "Edm.String");
personDetailsAddressType.addField("city", "Edm.String");
personDetailsAddressType.addField("state", "Edm.String");
personDetailsAddressType.addField("zipCode", "Edm.String");
personDetailsAddressType.addField("country", "Edm.String");

TargetEntityType personDetailsType
        = builder.addTargetEntityType(
                           "odata", "personDetails");
personDetailsType.addPkField("personId", "Edm.Int32");
personDetailsType.addField("age", "Edm.Int32");
personDetailsType.addField("gender", "Edm.Boolean");
personDetailsType.addField("phone", "Edm.String");
personDetailsType.addField(
             "address", "odata.personDetailsAddress");