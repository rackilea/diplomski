Map<String, Set<Person>> groupBy = persons.parallelStream()
    .collect(Collector.of(
        ConcurrentHashMap::new,
        ( map, person ) -> {
            map.computeIfAbsent(person.name, k -> new HashSet<>()).add(person);
            map.computeIfAbsent(person.uid, k -> new HashSet<>()).add(person);
            map.computeIfAbsent(person.phone, k -> new HashSet<>()).add(person);
        },
        ( a, b ) -> {
            b.forEach(( key, set ) -> a.computeIfAbsent(key, k -> new HashSet<>()).addAll(set));
            return a;
        }
    ));