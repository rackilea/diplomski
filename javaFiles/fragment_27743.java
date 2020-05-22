public List<Customer> getCustomerList() {
    if (customerList.size() == 0) {
        fillCustomerList();
    }
    return customerList;
}