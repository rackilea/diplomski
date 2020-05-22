final List<Set<Person>> groupedPersons = persons.stream()
        .collect(Collectors.groupingBy(o -> o.address.streetId, 
                Collector.of(() -> new LinkedHashSet<Person>(), HashSet::add, (s1, s2) -> {
            s1.addAll(s2);
            return s1;
        })))
        .entrySet().stream()
        .map(Map.Entry::getValue).collect(Collectors.toList());