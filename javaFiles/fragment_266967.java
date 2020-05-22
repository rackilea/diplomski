Map<String, List<Long>> map1 = personList.stream()
            .collect(Collectors.groupingBy(Person::getDepartment,
                    Collectors.mapping(Person::getTimestamp,
                            Collectors.collectingAndThen(
                                    Collectors.toCollection(TreeSet::new),
                                    ArrayList::new))));