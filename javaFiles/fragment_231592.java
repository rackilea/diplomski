List<Map<String, Object>> list = List.of(
                Map.of("name", "AQA Chief Officer"),
                Map.of("name", "AQA Internal Accounts"),
                Map.of("name", "AQA Legacy Planner"),
                Map.of("name",
                        "AQA Principal Facilitator"));

        List<String> result = list.stream()
                .flatMap(map -> map.values().stream())
                .map(Object::toString)
                .collect(Collectors.toList());

        result.forEach(System.out::println);