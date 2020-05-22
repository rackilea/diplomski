String uri = "https://uat.ws2.rki.dk/person.asmx";

Jaxb2Marshaller jaxb2 = new Jaxb2Marshaller();
jaxb2.setContextPath(request.getClass().getPackage().getName());
WebServiceTemplate ws = getWebServiceTemplate();
ws.setMarshaller(jaxb2);
ws.setUnmarshaller(jaxb2);