XMLInputFactory xif = XMLInputFactory.newFactory();

//prevents using external resources when parsing xml
xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);

//prevents using external document type definition when parsing xml
xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);