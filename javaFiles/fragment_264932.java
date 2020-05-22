Multimap<Integer, String> maps =  ArrayListMultimap.create();
maps.put(1, "foo");
maps.put(1, "bar");
maps.put(1, "foo");
maps.put(2, "Hello");
maps.put(2, "foo");
maps.put(2, "World");
maps.put(2, "World");

Here is the idea to print the occurences per value :

maps.keySet().stream() //Iterate the `keys`
            .map(i -> i + " : " +  //For each key
                        maps.get(i).stream() //stream the values.
                            .collect( //Group and count
                                    Collectors.groupingBy(
                                            Function.identity(), 
                                            Collectors.counting()
                                    )
                            )
            )
            .forEach(System.out::println);