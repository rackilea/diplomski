public class Numbers implements Iterable<Integer> {
    private int[] array;
    private int i;
    public Numbers(int[] array) { 
        this.array = array;
        i = 0; 
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() { return true; }

            @Override
            public Integer next() {
                int j = i;
                i = (i + 1) % array.length;
                return array[j];
            }

            @Override
            public void remove() {}
        };
    }
}