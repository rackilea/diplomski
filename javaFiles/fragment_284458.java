Optional<Customer> foundCustomer = Optional.empty();
for (Customer customer : customers) {
    if (customer.getID() == id) {
        foundCustomer = Optional.of(customer);
        break;
    }
}