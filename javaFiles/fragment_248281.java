CSVReader reader = ...;
CSVWriter writer = ...;

Multimap<String, String> results = TreeMultimap.create();

// read the file
String[] line;
for ((line = reader.readNext()) != null) {
    results.put(line[0], line[1]);
}

// output the file
Map<String, Collection<String>> mapView = results.asMap();
for (Map.Entry<String, Collection<String> entry : mapView.entries()) {
    String[] nextLine = new String[2];
    nextLine[0] = entry.getKey();
    nextLine[1] = formatCollection(entry.getValue());
    writer.writeNext(nextLine);
}