public class Main {
private String name;
private int year;

public Main(String name, int year) {
    this.name = name;
    this.year = year;
}

public String getName() {
    return name;
}

public int getYear() {
    return year;
}

public static void main(String[] args) {
    Map<Integer, Main> input = new LinkedHashMap<>();

    input.put(1, new Main("Chris", 1980));
    input.put(2, new Main("Daphne", 1981));
    input.put(3, new Main("Sandra", 1976));
    input.put(4, new Main("Adele", 1980));

    input.entrySet().stream().map(Map.Entry::getValue)
            .collect(Collectors.groupingBy(Main::getYear))
            .forEach((key, value) -> System.out.println(
                    key + ": " + String.join(", ", value.stream().map(Main::getName)
                            .collect(Collectors.toList()))));
}
}