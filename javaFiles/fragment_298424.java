Set<List<List<String>>> outerMostSet = new HashSet<>();
    List<List<String>> middleList = new ArrayList<>();
    List<String> innerMostList = new ArrayList<>();
    innerMostList.add("foo");
    innerMostList.add("bar");
    middleList.add(innerMostList);

    List<String> anotherInnerMostList = new ArrayList<>();
    anotherInnerMostList.add("another foo");

    middleList.add(anotherInnerMostList);
    outerMostSet.add(middleList);

    outerMostSet.stream()
                .flatMap(mid -> mid.stream())
                .flatMap(inner -> inner.stream())
                .forEach(System.out::println);