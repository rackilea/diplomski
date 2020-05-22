//look at the results
    SortedSet<String> sorted = new TreeSet<>();
    for (Future<String> result : results){
        sorted.add(result.get());
    }
    sorted.forEach(System.out::println);