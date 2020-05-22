Customer customer = ...; // get the customer from some place
try {

    // some code here

    customer.createInvoice();

    // more code here

} catch (CustomerNotEnrolledException e) {
    // handle CustomerNotEnrolledException here, maybe show error message?
    System.out.println("Exception creating invoice for customer " + customer.getName() + ": " + e.getMessage());
}