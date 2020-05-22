String str = "GenericRequest.param[i]&SpecificRequest.param[i]=XYZ&GenericRequest.param[i]";
    Map<String, Long> map = Arrays.stream(str.split("&")).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    System.out.println(map);
    List<String> list = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
            .map(e -> e.getKey() + (e.getValue() == 1 ? "" : "=" + e.getValue())).collect(Collectors.toList());
    System.out.println(list);