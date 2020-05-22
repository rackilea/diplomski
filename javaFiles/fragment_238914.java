public static void listCustomers(List<Customer> customers) { 
    CustomerComparator comparator = new CustomerComparator();
    customers.sort(comparator);

    System.out.format("\033[31m%s\033[0m%n", "Customers");
    System.out.format("\033[31m%s\033[0m%n", "=========");
    for (Customer c : customers) {
        System.out.format("\033[33m%s\033[0m%n", "Customer"); 
        System.out.format("\033[33m%s\033[0m%n", "--------"); 
        System.out.println(c);
    }       
}