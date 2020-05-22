List<Info> listResult = Stream.concat(
    listInfo.stream()
        .filter(info -> info.getDate().getTime() < date.getTime())
        .collect(Collectors.toMap(Info::getGroupId, Function.identity(),
            BinaryOperator.maxBy(Comparator.comparing(Info::getDate))))
        .values().stream(),
    listInfo.stream()
        .filter(info -> info.getDate().getTime() >= date.getTime())
    )
    .collect(Collectors.toList());