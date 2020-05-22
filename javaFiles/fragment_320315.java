Map<String,Float> scoreMap = new HashMap<>();
TreeMap<Float,String> thresholdMap = new TreeMap<>();

scoreMap.put("name1", 1.0f);
scoreMap.put("name2", 2.0f);
scoreMap.put("name3", 3.0f);
scoreMap.put("name4", 5.0f);

thresholdMap.put(0.5f, "comment0");
thresholdMap.put(1.5f, "comment1");
thresholdMap.put(4.5f, "comment2");

Map<String,List<String>> result =
    scoreMap.entrySet()
            .stream()
            .collect(Collectors.groupingBy(
                e -> thresholdMap.floorEntry(e.getValue()).getValue(),
                Collectors.mapping(Map.Entry::getKey, Collectors.toList())
            ));