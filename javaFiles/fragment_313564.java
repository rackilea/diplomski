ByteArrayOutputStream os = new ByteArrayOutputStream();
marshaller.marshal(c, os);
byte[] xml = os.toByteArray();
jc = JAXBContext.newInstance(Candidate.class);
Unmarshaller jaxb = jc.createUnmarshaller();
ByteArrayInputStream is = new ByteArrayInputStream(xml);