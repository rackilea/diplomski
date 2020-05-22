metaObject.unit = Arrays.stream(line
    .split(",", -1))
    .skip(line.startsWith("@UNIT,") ? 1 : 0)
    .map(String::trim)
    .map(s -> s.isEmpty() || "_".equals(s) ? null : s)
    .collect(Collectors.toList());