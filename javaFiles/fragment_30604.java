// Assuming this is your list
List<String> myList = Arrays.asList("Carhood", "Carlight", "Tree", "Red", "Carrom");

// using a filter and then collecting 'similar words' to a list
List<String> collect = myList.stream()
                             .filter(s -> s.contains("Car"))
                             .collect(Collectors.toList());

// to print it out
collect.forEach(System.out::println);