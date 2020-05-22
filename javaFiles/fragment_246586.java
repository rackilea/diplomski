private PriorityQueue<Customer> priorityCustomers;

Sub2() {
    super(new PriorityQueue<Customer>());
    this.priorityCustomers = (PriorityQueue<Customer>)(this.customers);
}