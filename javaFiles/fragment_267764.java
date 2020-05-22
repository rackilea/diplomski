Map<Integer, Set<String>> map = personList.stream()
    .collect(Collectors.groupingBy(o -> o.age,
        Collector.of(HashSet::new, (s,p) -> s.addAll(p.hobbies), (s1,s2) -> {
            s1.addAll(s2);
            return s1;
        })));