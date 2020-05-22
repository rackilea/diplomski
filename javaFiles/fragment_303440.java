public class Generator {
    private volatile List<Integer> list; 

    public Generator() {
        List<Integer> temp = = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            temp.add(i);
        }
        list = temp;
    }