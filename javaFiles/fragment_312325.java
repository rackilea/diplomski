Map<Second,First> result =
    listOfFirst.stream()
               .flatMap(p->p.getSecondDetails()
                            .stream()
                            .map(sec -> new SimpleEntry<>(sec,p))
               .collect(Collectors.toMap(Map.Entry::getKey,
                                         Map.Entry::getValue));