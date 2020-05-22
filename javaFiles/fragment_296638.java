yourModels.stream()
          .flatMap(model -> model.getProperties().stream()
                  .map(property -> new AbstractMap.SimpleEntry<>(model, property.getName())))
          .collect(Collectors.groupingBy(
                Entry::getValue, 
                Collectors.mapping(
                    Entry::getKey, 
                    Collectors.toSet())));