public void saveToXML(YourDomainObject obj) throws JAXBException, IOException {
                JAXBContext context = JAXBContext.newInstance(obj.getClass());
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(obj, new FileWriter(new File("filename.xml")));

        }