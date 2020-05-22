Map<String, ArrayList<Double>> REGISTRY = new HashMap<String, ArrayList<Double>>();
REGISTRY.add("Month", new ArrayList<Double>());

Scanner scanner = new Scanner(new File("filename"));
while (scanner.hashNextLine()) {
    String[] line = scanner.nextLine().split(",");

    // for the month key
    String month = line[0].split(" ")[1];
    REGISTRY.get("Month").add(new Double(month));

    // then for the rest of the entries
    if (!REGISTRY.containsKey(line[1])) {
        REGISTRY.add(line[1], new ArrayList<Double>());
    }
    REGISTRY.get(line[1]).add(new Double(line[2]));
}