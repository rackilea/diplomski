public class StringComparator implements Comparator<String> {
    private int count = 0;

    @Override
    public int compare(String o1, String o2) {
        ++count;
        return o1.compareTo(o2);
    }

    public int getCount() { return count; }
    public void reset() { count = 0; }

    public static void main(String[] args) {
        StringComparator sc = new StringComparator();
        TreeMap<String, String> map = new TreeMap<>(sc);
        map.put("foo", "one");
        System.out.println("foo took " + sc.getCount() + " comparisons");
        sc.reset();
        map.put("bar", "two");
        System.out.println("bar took " + sc.getCount() + " comparisons");
    }
}