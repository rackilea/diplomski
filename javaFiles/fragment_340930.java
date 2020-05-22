public void addCustomer()
{
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter customer name: ");
    String name = scanner.nextLine();
    //any additional details
    Customer customer = new Customer(name, otherParams);
    customers.add(customer);
}