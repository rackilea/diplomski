BlackListCode blackListCode = new BlackListCode();
blackListCode.setClEntityIdInfoExt(new ClEntityIdInfoExt("58241962"));
blackListCode.setGeneralCollectionEntityInfoExt(new GeneralCollectionEntityInfoExt("D"));

JAXBContext jaxbContext = JAXBContext.newInstance(BlackListCode.class);
Marshaller marshaller = jaxbContext.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
marshaller.marshal(blackListCode, System.out);