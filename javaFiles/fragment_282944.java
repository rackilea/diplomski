return Stream.<Supplier<List<Something>>>of(
            () -> repository.getDataWayOne(data.getParameter()),
            () -> repository.getDataWayTwo(data.getParameter()),
            () -> repository.getDataWayThree(data.getParameter().getAcessoryParameter()),
            () -> Collections.singletonList(repository.getDefaultData(data.getParameter()))
        )
        .map(Supplier::get)
        .filter(l -> !l.isEmpty())
        .findFirst()
        .orElse(null);