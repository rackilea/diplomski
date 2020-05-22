ObjectRelationalDataTypeDescriptor descriptor = new ObjectRelationalDataTypeDescriptor();
    // SECTION: DESCRIPTOR
    descriptor.setJavaClass(Phone.class);
    Vector vector = new Vector();
    vector.addElement("PolicyHolders");
    descriptor.setTableNames(vector);

    // SECTION: PROPERTIES
    descriptor.descriptorIsAggregate();

    descriptor.setStructureName("PHONE_TYPE");
    descriptor.addFieldOrdering("PHONETYPE");
    descriptor.addFieldOrdering("AREACODE");
    descriptor.addFieldOrdering("PHONENUMBER");

    descriptor.addDirectMapping("type", "getType", "setType", "PHONETYPE");
    descriptor.addDirectMapping("areaCode", "getAreaCode", "setAreaCode", "AREACODE");
    descriptor.addDirectMapping("number", "getNumber", "setNumber", "PHONENUMBER");