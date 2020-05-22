public class Cost implements Comparable<Cost> {
    String name;
    double cost;
    int id;

    public Cost(int id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    @Override
    public int compareTo(Cost s) {
        return Double.compare(cost, s.cost);
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("id : ").append(id).append(
                " name: ").append(name).append(" cost :").append(cost)
                .toString();

    }
}