public class StringArrayComparator implements Comparator<String[]> {
    @Override
    public int compare(String[] a, String[] b) {
        double aVal = Double.valueOf (a[2]) / Double.valueOf (a[1]);
        double bVal = Double.valueOf (b[2]) / Double.valueOf (b[1]);

        return Double.compare(aVal, bVal);
    }
}