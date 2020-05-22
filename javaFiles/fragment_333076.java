public class Blah {
    private final Collection<Integer> collection = new ArrayList<Integer>();

    public Blah(Collection<Integer> collection) {
        this.collection.addAll(collection);
    }
}