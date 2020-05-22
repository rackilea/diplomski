//supplier of TreeMap with your custom comparator
Supplier<TreeMap<Integer, String>> myMapSupplier = () -> new TreeMap<>(Comparator.reverseOrder());

Map<Integer, String> result = myMap.values()
             .stream()
             .collect(Collectors.toMap(Person::getScore, Person::getName, (s, s2) -> s, myMapSupplier));