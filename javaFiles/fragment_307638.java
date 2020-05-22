public class SortDemonstration {

    public static void main(String[] args) {

        String[][] table = {
                {"The", "Quick",  "Brown"},
                {"Fox", "Jumped", "Over"},
                {"A",   "Lazy",   "Dog"}
            };

        Arrays.sort( table, new ColumnComparator(0));
        System.out.println( Arrays.deepToString(table));

        Arrays.sort( table, new ColumnComparator(1));
        System.out.println( Arrays.deepToString(table));

        Arrays.sort( table, new ColumnComparator(2));
        System.out.println( Arrays.deepToString(table));
    }

    private static class ColumnComparator implements Comparator<String []>{
        private final int index;
        public ColumnComparator(int index) {
            this.index = index;
        }
        @Override
        public int compare(String[] o1, String[] o2) {
            return o1[index].compareTo(o2[index]);
        }

    }

}