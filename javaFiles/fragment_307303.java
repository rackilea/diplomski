public static void main(String[] args) throws Exception {

    JAXBContext ctxt = JAXBContext.newInstance(CustomerWrapper.class);
    Marshaller m = ctxt.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    Customer customer = new Customer("John", "Doe");
    m.marshal(new JAXBElement<CustomerWrapper>(new QName("cwrapper"), CustomerWrapper.class, new CustomerWrapper(customer)), System.err);

}

static class CustomerWrapper {
    private Customer customer;

    public CustomerWrapper() {
    }

    public CustomerWrapper(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

@XmlJavaTypeAdapter(CustomerAdapter.class)
static class Customer {
    private String name;
    private String lastName;
    public Customer() {
    }
    public Customer(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

static class CustomerAdapter extends XmlAdapter<String, Customer> {

    @Override
    public Customer unmarshal(String v) throws Exception {
        String[] ss = v.split(" ");
        return new Customer(ss[0], ss[1]);
    }

    @Override
    public String marshal(Customer v) throws Exception {
        return v.getName() + " " + v.getLastName();
    }

}