public static void main(String[] args) {

        try {

            StringWriter stringWriter = new StringWriter();

            Customer c = new Customer();
            c.setAge(1);
            c.setName("name");

            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(new JAXBElement<Customer>( new QName("", "Customer"), Customer.class, null, c), stringWriter);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            InputStream is = new ByteArrayInputStream(stringWriter.toString().getBytes());
            JAXBElement<Customer> customer = (JAXBElement<Customer>) jaxbUnmarshaller.unmarshal(new StreamSource(is),Customer.class);

            c = customer.getValue();

          } catch (JAXBException e) {
            e.printStackTrace();
          }

}