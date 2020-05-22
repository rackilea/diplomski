List<Parent> parents = 
    grouped.entrySet()
           .stream()
           .flatMap(e1 -> e1.getValue()
                            .entrySet()
                            .stream()
                            .map(e2 -> new Parent(e1.getKey(),e2.getKey(),e2.getValue())))
           .collect(Collectors.toList());