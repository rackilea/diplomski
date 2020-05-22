public void lend(Customer customer) {
    this.customer = customer;
}

public void receiveBack() {
    customer = null;
    pageNumber = 0;
}

public boolean isAvailable() {
    return (customer == null);
}