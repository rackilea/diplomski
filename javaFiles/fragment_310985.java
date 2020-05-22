factory.setServiceClass(...);
factory.setAddress(...);
factory.getFeatures().add(new WSAddressingFeature());
SomePortType client = (SomePortType) factory.create();
AddressingProperties maps = new AddressingPropertiesImpl();
EndpointReferenceType epr = new EndpointReferenceType();

//Then you can add referenceParameters to the epr
ReferenceParametersType ref = new ReferenceParametersType();
List<Object> paras = ref.getAny();
Country ctry = new Country("xx");

JAXBContext ctx = JAXBContext.newInstance(new Class[] {Country.class });
Marshaller marshaller = ctx.createMarshaller();
DOMResult res = new DOMResult();
marshaller.marshal(ctry, res);
Element elt = ((Document) res.getNode()).getDocumentElement();
any.add(elt);

epr.setReferenceParameters(ref);
maps.setTo(epr);

((BindingProvider)client).getRequestContext()
    .put(JAXWSAConstants.CLIENT_ADDRESSING_PROPERTIES, maps);