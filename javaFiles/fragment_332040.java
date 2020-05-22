Map<String,List<Person>> map =
    persons.stream()
           .flatMap(p -> p.childrenListHolder.children.stream().map(c -> new AbstractMap.SimpleEntry<>(c, p)))
           .collect(Collectors.groupingBy(
             e -> e.getKey().childrensName,
             Collectors.mapping(Map.Entry::getValue, Collectors.toList())
           ));