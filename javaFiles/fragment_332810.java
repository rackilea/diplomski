Collection<Map<String, Object>> finalMaps = products.stream()
        .collect(groupingBy(it -> it.get("Id"), Collectors.collectingAndThen(
                Collectors.toList(),
                maps -> (Map<String, Object>) maps.stream()
                        .reduce(new HashMap<>(), (result, map) -> {
                            final List<Object> numbers = (List<Object>) result.getOrDefault("number", new ArrayList<>());

                            result.put("Id", map.getOrDefault("Id", result.getOrDefault("Id", null)));
                            result.put("location", map.getOrDefault("location", result.getOrDefault("location", null)));

                            if (map.containsKey("number")) {
                                numbers.add(map.get("number"));
                            }
                            result.put("number", numbers);

                            return result;
                        }))
                )
        )
        .values();

System.out.println(finalMaps);