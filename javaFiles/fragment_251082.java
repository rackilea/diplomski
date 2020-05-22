Map<String, List<String>> fileMap = new HashMap<>();
fileMap.put("Set1.txt", Arrays.asList("tuffing", "attityd", "underskott"));
fileMap.put("Set2.txt", Arrays.asList("binnikemask", "vågat", "cognac"));
fileMap.put("Set3.txt", Arrays.asList("rseelse", "spjäla", "ljud"));
List<String> values = IntStream.range(0, 3)
        .<Stream<String>>mapToObj(index ->
            fileMap.values().stream().map(list -> list.get(index)))
        .flatMap(Function.identity())
        .collect(Collectors.toList());
System.out.println(values);