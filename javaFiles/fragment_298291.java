//Order class
 private Customer customer;
 private Address  shippingAddress;
 private Payment  paymentInformation;
 private Address  billingAddress

..

public Response createOrder(
    @ModelAttribute("order") Order order) {
    // Create the order
}