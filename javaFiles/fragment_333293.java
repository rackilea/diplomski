Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
Resource schema = new ClassPathResource("fruit.xsd");
marshaller.setSchema(schema);
marshaller.setContextPath("com.fruit.xml.jaxb");
// manually call Spring lifecycle method which actually loads the schema resource
marshaller.afterPropertiesSet();
// use marshaller...