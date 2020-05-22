List<Customer> customers = Arrays.asList(
        new Customer(10, true, 5),
        new Customer(11, true, 3),
        new Customer(20, false, 12),
        new Customer(21, false, 11));

Map<Boolean, Integer> sum = customers
        .stream()
        .collect(Collectors.groupingBy(Customer::isActive, Collectors.summingInt(Customer::getBillingCount)));
System.out.println(sum);

Map<Boolean, Double> avg = customers
        .stream()
        .collect(Collectors.groupingBy(Customer::isActive, Collectors.averagingInt(Customer::getBillingCount)));
System.out.println(avg);