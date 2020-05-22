JAXBContext context = JAXBContext.newInstance(Template.class);
Unmarshaller unmarshaller = context.createUnmarshaller();
Template template = (Template) unmarshaller.unmarshal(new File("template.xml"));
Marshaller marshaller = context.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
marshaller.marshal(template, System.out);