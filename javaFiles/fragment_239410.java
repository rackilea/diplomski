List<String> result = Stream.of("A", "A", "BB", "C", "BB", "D")
            .collect(Collectors.groupingBy(
                         Function.identity(), 
                         Collectors.counting()))
            .entrySet()
            .stream()
            .filter(x -> x.getValue() == 1L)
            .map(Entry::getKey).collect(Collectors.toList());

System.out.println(result); // [C, D]