List<String> stockList2 = 
    stockList.stream()
             .filter(e -> !e.contains("M"))
             .map(String::toLowerCase)
             .collect(Collectors.toList());
stockList2.forEach(System.out::println);