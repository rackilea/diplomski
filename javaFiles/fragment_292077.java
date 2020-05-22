class SomeClass {

    List<CustomerPersister> customerPersisters;

    @Autowired
    SomeClass(List<CustomerPersister> customerPersisters) {
        this.customerPersisters = customerPersisters;
    }

    public void setAbuserDetails(@RequestBody AbuserDetails customer) {
        for (CustomerPersister customerPersister: customerPersisters) {
            customerPersister.setAbuserDetails(customer);
        }
    }
}