public class MyObject {
    private int id;
    private String name;
    private String location;
    private Integer value;
    private String category;
    private String state;

    public MyObject(String entry) {
        String[] parts = entry.split("\\|");
        if (parts.length != 6) {
            throw new IllegalArgumentException("entry has not 6 parts");
        }
        id = Integer.parseInt(parts[0]);
        name = parts[1];
        location = parts[2];
        try {
            value = Integer.parseInt(parts[3]);
        } catch (NumberFormatException ignored) {
        }
        category = parts[4];
        state = parts[5];
    }

    // getters

    @Override
    public String toString() {
        return String.join("|", String.valueOf(id), name, location, String.valueOf(value), category, state);
    }
}