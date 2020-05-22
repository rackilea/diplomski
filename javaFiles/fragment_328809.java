List<Item> particulatItems = new ArrayList<>();

// using try-with-resource that will help closing BufferedReader by own
try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    String line;
    while ((line = br.readLine()) != null) {
       particularItems.add(processLine(line));
    }
}