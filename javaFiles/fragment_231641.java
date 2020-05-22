Customer customer = new Customer();
//set customer attributes 
JAXBContext jc = JAXBContext.newInstance(Customer.class);
Marshaller marshaller = jc.createMarshaller();
StringWriter stringWriter = new StringWriter();
marshaller.marshal(customer, stringWriter );
log.info(stringWriter.toString());