TreeMap<String, List<List<String>>> allResults = new TreeMap<>();
    allResults.put("a", Arrays.asList(Arrays.asList("469", "470"), Arrays.asList("206", "1013", "1014"), Arrays.asList("2607", "2608")));
    allResults.put("b", Arrays.asList(Arrays.asList("169", "470")));
    allResults.put("c", Arrays.asList(Arrays.asList("269", "470")));

    String result = allResults.entrySet().stream()
                      .map(i -> i.getKey() + "," + i.getValue().stream().map(elements -> String.join(":", elements))
                                      .collect(Collectors.joining(", "))
                                      )
                      .collect(Collectors.joining("\n"));

    System.out.println(result);