@Entity class Customer {
    @Id long id;
    @Backlink(to = "customer") ToMany<Order> orders;
}

@Entity class Order {
    @Id long id;
    ToOne<Customer> customer;
}

long[] orderIds = orderBox.query()
    .equal(Order_.customerId /* virtual property */, customer.id)
    .build()
    .findIds()