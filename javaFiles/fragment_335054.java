movies.stream()
    .filter(m -> m.getActors().stream()
        .anyMatch(
            a -> a.getFirstName().equalsIgnoreCase(firstName) 
                && a.getLastName().equalsIgnoreCase(lastName)))
    .collect(Collectors.toList());