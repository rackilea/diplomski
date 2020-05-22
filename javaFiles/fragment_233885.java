List<Integer> result = myList.stream()
        .map(list -> list.stream()
                        .flatMapToInt(map -> map.values()
                                                .stream()
                                                .mapToInt(i -> (int) i))
                        .sum())
        .collect(Collectors.toList());