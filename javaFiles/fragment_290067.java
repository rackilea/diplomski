List<String> keywords = Arrays.asList("Apple", "Ananas", "Mango", "Banana", "Beer");

Map<Character, List<String>> result = keywords.stream()
     .sorted()
     .collect(Collectors.groupingBy(it -> it.charAt(0)));

System.out.println(result);