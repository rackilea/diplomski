public class Limited {
    public static final List<Limited> ALL_INSTANCES = 
        Collections.unmodifiableList(createInstances());

    private int id;

    private static List<Limited> createInstances() {
        List<Limited> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(new Limited(i));
        }
    }

    private Limited(int id) {
        this.id = id;
    }
}