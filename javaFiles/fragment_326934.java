List<String> secondFileContents = Files.readAllLines(Paths.get("C:\\secondFile"));
Function<String,YourJavaObject> mapper = line -> {
    if ("abc".equals(secondFileContents.get(2))) {
        System.out.println("abc found!");
    }
    return new YourJavaItem(line);
}
List<YourJavaItem> result = Files.lines(firstFile).skip(1)
                                .map(mapper)
                                .collect(Collectors.toList());