Map<String, Integer> auto = new HashMap<>();
auto.put("Merc", 3);
auto.put("Citroen", 5);
auto.put("Opel", 10);
auto.put("BMW", 20);

List<String> given = new ArrayList<>();
given.add("Opel");
given.add("BMW");
given.add("Citroen");

// to sort the selected elements.
given.sort(Comparator.comparing(auto::get));

// to sort all elements.
List<String> names = auto.entrySet().stream()
        .sorted(Comparator.comparing(Map.Entry::getValue))
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());