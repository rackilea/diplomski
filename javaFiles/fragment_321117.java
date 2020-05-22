Map<Unit, Integer> allRequirements = 
    person.getUnitAmounts()
          .stream()
          .flatMap(unitAmountPerson -> 
             unitAmountPerson.getUnit()
                             .getRequirements()
                             .stream()
                             .map(r -> new AbstractMap.SimpleEntry<>(unitAmountPerson.getAmount(), r))
          )
          .collect(Collectors.toMap(
             e -> e.getValue().getUnit(),
             e -> e.getKey() * e.getValue().getAmount(),
             Integer::sum
          ));