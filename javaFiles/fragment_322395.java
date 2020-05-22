Marshaller marshaller = JAXBContext.newInstance(entity.getClass()).createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
StringWriter sw = new StringWriter();
marshaller.marshal(entity, sw);

return Response.ok(sw.toString(), MediaType.APPLICATION_XML_TYPE).build();