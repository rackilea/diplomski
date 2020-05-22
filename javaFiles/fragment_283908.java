public class Employee {

    private final int id;
    private final String name;

    public Employee(String text) {
        String[] parts = text.split(" ");
        id = Integer.parseInt(parts[2]);
        name = parts[0] + " " + parts[1];
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}