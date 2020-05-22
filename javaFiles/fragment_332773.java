Customer[] customers = new Customer[100];
customers[0] = new Customer();
...
for (Customer customer : customers) {
   System.out.println(customer.getAccountOwnerName());
   System.out.println(customer.getAccountOwnerPersonalNumber());
}