List<Summary> overallResult = lookup.entrySet().stream()
        .flatMap(en -> EnumSet.allOf(Status.class).stream()
                .map(status -> en.getValue().containsKey(status) ?
                        en.getValue().get(status) : Summary.builder()
                                .date(en.getKey()).status(status).count(0).build()))
        .collect(Collectors.toList());