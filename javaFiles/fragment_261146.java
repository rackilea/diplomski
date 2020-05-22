Collection<Child> filteredChildren = 
    parents.stream()
           .flatMap(p -> p.getChildren()
                          .stream()
                          .filter(c -> c.getType().equals("A")))
           .collect(Collectors.toList());