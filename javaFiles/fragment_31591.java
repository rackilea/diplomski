public class Food implements Comparable<Food> {
    private int id;
    private String name;
    private float score; // or maybe kcal... ?

    public Food(int id, String name, float score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Food other) {
        return id - other.getId();

        // use the following if you want to sort by name instead
        // return name.compareTo(other.getName());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}