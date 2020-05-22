Map<String, Integer> cities=ownerMap.entrySet()
            .stream()
            .collect(Collectors.groupingBy(e -> e.getKey().getCity(), Collectors.summingInt(e -> e.getValue().size())));

cities.forEach((name, count) -> {
        System.out.println(name + ":" + count);
    });