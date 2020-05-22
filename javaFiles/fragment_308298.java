List<Pojo> groups = result.entrySet()
        .stream()
        .flatMap(sport -> sport.getValue()
                        .entrySet().stream()
                        .map(gender -> new Pojo(sport.getKey(), 
                                                gender.getKey(), 
                                                gender.getValue())))
        .collect(Collectors.toList());