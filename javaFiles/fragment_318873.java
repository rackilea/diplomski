public class CustomerList {
    private int customerCount = 0;
    private List<Customer> customers = new ArrayList<>();

    public boolean addCustomer(String name,
            String street,
            String city,
            String postcode,
            String type) {

        Customer customer = new Customer("ID" + customerCount++,
                name,
                street,
                city,
                postcode,
                type);

        return customers.add(customer);
    }
}