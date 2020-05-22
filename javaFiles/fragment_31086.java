@XmlRootElement(name = "customers")
class Customers {
    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    @XmlElement(name = "customer")
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}