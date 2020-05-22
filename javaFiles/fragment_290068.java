Map<Character, List<String>> result = Stream
      .of( "Apple", "Ananas", "Mango", "Banana","Beer")
      .sorted()
      .collect(Collectors.groupingBy(it -> it.charAt(0)))

System.out.println(result);