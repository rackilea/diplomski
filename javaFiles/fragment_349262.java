Map<E, List<A>> output = input.stream()
        .collect(Collectors.groupingBy(A::getE,
                Collectors.groupingBy(e -> e.getName().length(),
                        TreeMap::new, Collectors.toList()))) // Map<E, TreeMap<Integer, List<A>>> // the nested groupings
        .entrySet().stream()
        .collect(Collectors.toMap(Map.Entry::getKey,
                m -> m.getValue().lastEntry().getValue())); // only max length entry mapped here