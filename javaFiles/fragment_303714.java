private void customerRemove() {
    customers = new LinkedList<Customer>();
    customers.add(new Customer(1, "John", 20));
    customers.add(new Customer(2, "Mike", 21));
    customers.add(new Customer(3, "Harry", 22));
    System.out.println("\nRemoving a customer.");
    System.out.print("Enter a customer ID: ");
    int rmvId = In.nextInt();

    boolean found=false;
    for (Customer rmvCustomer : customers) {
        if (rmvCustomer.getID() == rmvId) {
            customers.remove(rmvCustomer);
            System.out.println("Customer removed.");
            System.out.println(" ")
            found=true;
            break;
        }
    }
    if(!found)
     System.out.println("That customer does not exist.\n");
}