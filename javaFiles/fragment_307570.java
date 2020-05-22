Map<LocalDate, String> tree = new TreeMap<>();

for (Map.Entry<String, String> entry : map.entrySet()) {
    System.out.println(entry);
    String key = entry.getKey();
    String value = entry.getValue();

    LocalDate ld = LocalDate.parse(key, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    tree.put(ld, value);
}

for (LocalDate key : tree.keySet()) {
    System.out.println(key);
}