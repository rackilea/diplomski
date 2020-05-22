BlackListCode blackListCode = new BlackListCode();
blackListCode.setEntityId("58241962");
blackListCode.setBlackListCode("D");

JAXBContext jaxbContext = JAXBContext.newInstance(BlackListCode.class);
Marshaller marshaller = jaxbContext.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
marshaller.marshal(blackListCode, System.out);