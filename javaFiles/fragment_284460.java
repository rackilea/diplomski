Map<String, Map<String, List<Unit>>> map =
    supply.getCompartments()
          .stream()
          .collect(groupingBy(
            Compartment::getItemId,
            flatMapping(c -> c.getUnits().stream(), groupingBy(Unit::getContainerNumber))
          ));