List<Person> persons = Arrays.asList(
    new Person(1, 18), //(id, age)
    new Person(2, 24),
    new Person(3, 14),
    new Person(4, 10)
);

//Same person can place multiple purchases.
List<PurchaseOrder> purchaseOrders = Arrays.asList(
    new PurchaseOrder(1, 24), //(person id, purchase amount)
    new PurchaseOrder(1, 40),
    new PurchaseOrder(2, 10),
    new PurchaseOrder(2, 24),
    new PurchaseOrder(3, 23),
    new PurchaseOrder(3, 45),
    new PurchaseOrder(4, 68),
    new PurchaseOrder(4, 12),
    new PurchaseOrder(4, 23)
);

Set<Integer> personIds = persons
    .stream()
    .filter(person -> person.getAge() < 18)
    .map(Person::getId)
    .collect(Collectors.toSet());

OptionalDouble average = purchaseOrders
    .stream()
    .filter(purchaseOrder -> personIds.contains(purchaseOrder.getPersonId()))
    .mapToInt(PurchaseOrder::getAmount)
    .average();