List<Path> filteredList = targetList.stream()
    .filter(f -> Files.exists(f))
    .filter(f -> applyAndClose(
        () -> Files.lines(f),
        lines -> lines.anyMatch(line-> line.contains(","))))
    .collect(toList());