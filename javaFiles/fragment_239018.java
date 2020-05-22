List<Node> nodes = map.entrySet()
        .stream()
        .flatMap(entry -> {
            String key = entry.getKey();
            Integer value = entry.getValue();
            return Arrays.stream(key.split("-"))
                    .map(splitKey -> new Node(Integer.valueOf(splitKey), value));
        })
        .collect(Collectors.toList());