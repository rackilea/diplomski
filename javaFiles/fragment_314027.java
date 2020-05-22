private static List<String> filterNumbers(List<String> numbers, String predicate) {
    List<String> filtered = new ArrayList<>();
    for (String n : numbers) {
        if (n.equals(predicate) || n.startsWith(predicate + '.')) {
            filtered.add(number);
        }
    }
    return filtered;
}