CustomerRequest request = new CustomerRequest()
  .id(testId)
  .firstName("Martin")
  .lastName("Mojko");

Result<Customer> result = gateway.customer().create(request);