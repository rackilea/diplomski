Customer customer = null;
for (Customer c: customers ) {
        if(c.getCustomer().equals(entity.getCustomer())) {
            customer = c;
            break;
        }
    }
if (customer == null) {
  customer  = new Customer(entity.getCustomer(), new ArrayList<>())
}