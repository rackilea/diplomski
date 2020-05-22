CsvReader doc = null;

try {

    doc = new CsvReader(""My CSV Name");
    doc.readHeaders();

    Map<String, Long> mostFrequent = new HashMap<String, Long>();

    while (doc.readRecord()) {

        Arrays.asList(doc.get("text"/*my column name*/).replaceAll("\\P{Alpha}", " ").toLowerCase().trim().split("[ ]+")).
        stream().forEach(word -> {

            if (mostFrequent.containsKey(word)) {
                mostFrequent.put(word, mostFrequent.get(word) + 1);  
            }
            else {
                mostFrequent.put(word, 1l);
            }
        });
    }

    Map<String, Long> sortedText = mostFrequent.entrySet().stream()
        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
        .limit(1000)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (e1, e2) -> e1, LinkedHashMap::new));

    sortedText.forEach((k, v) -> System.out.println("Word: " + k + " || " + "Count: " + v));

    doc.close();

} catch (IOException e) {
    e.printStackTrace();
} finally {
    doc.close();
}