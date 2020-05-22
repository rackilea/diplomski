Map<Integer, Set<String>> yourmap;
yourmap = personList.stream()
                    .flatMap(p -> p.hobbies.stream()
                                           .flatMap(hobby -> Stream.of(new SimpleEntry<>(p.age, hobby)))
                            )
                    .collect(Collectors.groupingBy(Entry::getKey,
                             Collectors.mapping(Entry::getValue, Collectors.toSet())));