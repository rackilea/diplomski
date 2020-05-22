public class Generator {
    private final List<Integer> list = new ArrayList<>();

    public Generator() {
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
    }