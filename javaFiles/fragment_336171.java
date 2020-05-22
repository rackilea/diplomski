return data.stream()
    .collect(Collectors.groupingBy(
        elem -> columns.stream()
            .map(elem::get)
            .filter(Objects::nonNull)
            .collect(Collectors.joining())));