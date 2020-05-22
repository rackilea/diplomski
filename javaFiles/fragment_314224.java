tmp = e.getValue()
        .stream()
        .map(struct -> new myStruct(struct.time, map2.get(e.getKey())
                                                           .stream()
                                                           .filter(x -> x.time.equals(struct.time))
                                                           .mapToInt(x -> struct.number / x.number)
                                                           .findFirst().getAsInt()))
        .collect(Collectors.toList());