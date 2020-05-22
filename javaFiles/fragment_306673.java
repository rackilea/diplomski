Map<Integer,List<Integer>> version2 = Arrays.stream(myArray).distinct().boxed()
            .flatMap(p -> IntStream.range(2, 100).filter(i -> p%i ==0).boxed()
                    .map(l->new AbstractMap.SimpleEntry<>(l,p)))
            .collect(Collectors.groupingBy(Map.Entry::getKey,
                    Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

    System.out.println(version2);