persons.stream()
        .filter(p -> personToUpdate.getName().equalsIgnoreCase(p.getName()))
        .findFirst()
        .ifPresentOrElse(
            p -> p.setAddress(personToUpdate.getAddress()),
            () -> persons.add(personToUpdate)
        );