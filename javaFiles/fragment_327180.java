customerRelationships.stream()
            .flatMap(relationship -> {
                boolean noneMatch = customers.stream().noneMatch(customer -> customer.getFirstName().equalsIgnoreCase(relationship.getFirstName()));
                if (noneMatch) {
                    return Stream.of(new BusinessCustomer(relationship.getFirstName(), relationship.getLastName()));
                } else {
                    return customers.stream()
                            .filter(customer -> customer.getFirstName().equalsIgnoreCase(relationship.getFirstName()))
                            .map(customer -> new BusinessCustomer(relationship.getFirstName(), relationship.getLastName(), customer.getAge()));
                }
            })
            .collect(Collectors.toList());