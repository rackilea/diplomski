final List<String> originalList = Arrays.asList("a","b");
    //JAVA 8
    //Always initialize maps/collections with their Interface
    final Map<Integer, String> mapFromListJavaEight =
            IntStream.range(0,originalList.size())
            .mapToObj(index -> index)
            .collect(Collectors.toMap(Function.identity(),
                    originalList::get));
    // JAVA < 8 & JAVA >= 5
    final Map<Integer, String> mapFromListJavaSeven =
            new HashMap<>();
    for(int i = 0; i < originalList.size(); i++){
        mapFromListJavaSeven.put(i,originalList.get(i));
    }