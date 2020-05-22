public class ComparatorWithData implements Comparator<V> {
    private String data;

    public ComparatorWithData(String data) {
        this.data = data;
    }

    @Override
    public int compare(V o1, V o2) {
        return o1.evaluateWeight(data).compareTo(o2.evaluateWeight(data));
    }
}