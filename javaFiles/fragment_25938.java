Map<String, Long> map = Arrays.stream("some text some spaces".split(" "))
                              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                              .entrySet()
                              .stream()
                              .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                              .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(),
                                        (v1, v2) -> v2, LinkedHashMap::new));

System.out.println(map); // This prints: {some=2, spaces=1, text=1}