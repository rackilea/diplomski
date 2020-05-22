Stream<BusinessCustomer> matches = customerRelationships.stream()
            .flatMap(relationship -> customers.stream()
                    .filter(customer -> customer.getFirstName().equalsIgnoreCase(relationship.getFirstName()))
                    .map(customer -> new BusinessCustomer(relationship.getFirstName(), relationship.getLastName(), customer.getAge())));

    Stream<BusinessCustomer> nonMatches = customerRelationships.stream()
            .filter(relationship -> customers.stream().noneMatch(customer -> customer.getFirstName().equalsIgnoreCase(relationship.getFirstName())))
            .map(relationship -> new BusinessCustomer(relationship.getFirstName(), relationship.getLastName()));

    List<BusinessCustomer> result = Stream.concat(matches, nonMatches)
            .collect(Collectors.toList());