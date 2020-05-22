List<File> filteredList = targetList.parallelStream()
    .filter(f -> f.exists())
    .filter(f -> applyAndClose(
        () -> new BufferedReader(new FileReader(f)),
        reader -> reader.lines().anyMatch(line-> (line.indexOf(",") !=-1))))
    .collect(Collectors.toList());