String path = "sample.csv";

// Read headers
String[] headers = headers(path);

List<Map<String, String>> result = null;

// Read data
try (Stream<String> stream = Files.lines(Paths.get(path))) {
    result = stream
        .skip(1) // skip headers
        .map(line -> line.split(","))
        .map(data -> {
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < data.length; i++) {
               map.put(headers[i], data[i]);
            }
            return map;
        })
        .collect(Collectors.toList());
}