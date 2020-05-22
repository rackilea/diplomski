List<String> properNames = customers.stream()
        .filter(c -> c.getLastName() != null)
        .map(Customer::getFirstName)
        .collect(Collectors.toList());

customers.removeIf(c -> c.getLastName() == null
        && properNames.contains(c.getFirstName()));