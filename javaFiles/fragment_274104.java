public class Department {
    final String number;
    final String name;
    final List<Integer> products = new ArrayList<>();

    Department(String number, String name) {
        this.number = number;
        this.name = name;
    }
}