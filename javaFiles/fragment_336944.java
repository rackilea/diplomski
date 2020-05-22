HashMap<Integer, HashMap<String, Object>> entireMap = new HashMap<>();
    entireMap.put(1, new HashMap<String, Object>() {{
        put("user_name", "Arthur");
        put("other_key1", "val");
        put("other_key2", "val");
    }});
    entireMap.put(2, new HashMap<String, Object>() {{
        put("user_name", "Bela");
        put("other_key2", "val");
    }});
    entireMap.put(3, new HashMap<String, Object>() {{
        put("user_name", "Ceasar");
    }});
    entireMap.put(4, new HashMap<String, Object>() {{
        put("user_name", "Ceasar");
    }});
    entireMap.put(5, new HashMap<String, Object>() {{
        put("user_name", "Bela");
    }});
    entireMap.put(6, new HashMap<String, Object>() {{
        put("user_name", "Bela");
    }});

    Map<Object, Long> result = entireMap
            .values()
            .stream()
            .map(map -> map.get("user_name"))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    System.out.println(result);

    Long max = Collections.max(result.values());
    System.out.println(max);