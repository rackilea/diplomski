public class Bro {
    private int index;
    private int value;
    public Bro (int index, int value) {
        this.index = index;
        this.value = value;
    }
    public static Comparator<Bro> getIndexComparator() {
        return new Comparator<Bro>() {
            public int compare(Bro o1, Bro o2) {
                return o1.index - o2.index;
            }
        }
    }
}
Bro[] bros = new Bro[5];
bros[0] = new Bro(1, 220);
...
Arrays.sort(bros, Bro.getIndexComparator());