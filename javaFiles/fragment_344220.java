List<ResultObject> resultObjects = samples.stream()
        .collect(Collectors.groupingBy(Sample::getId,
                Collectors.mapping(a -> new User(a.getUserName(), a.getAddress(), a.getEmail()),
                        Collectors.toList())))
        .entrySet().stream()
        .map(e -> new ResultObject(e.getKey(), e.getValue()))
        .collect(Collectors.toList());