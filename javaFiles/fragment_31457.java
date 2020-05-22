List<ClassB> result = source.stream()
                .collect(groupingBy(s -> s.getGroup() + "" + s.getId())) // Map<String, List<ClassA>>
                .values()  // Collection<List<ClassA>>
                .stream() // Stream<List<ClassA>>
                .map(ClassB::new) // Stream<ClassB>
                .collect(Collectors.toList()); //List<ClassB>>