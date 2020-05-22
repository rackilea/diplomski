List<List<String>> lists = null;
try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
    lists = stream.map(s -> Arrays.asList(s.split(",")))
                  .collect(Collectors.toList());
} catch (IOException e) {
    e.printStackTrace();
}