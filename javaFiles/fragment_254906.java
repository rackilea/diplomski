public class SectionComparator implements Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        Integer i1 = Integer.valueOf(s1.substring(s1.indexOf('_') + 1));
        Integer i2 = Integer.valueOf(s1.substring(s2.indexOf('_') + 1));
        return i1.compareTo(i2),
    }
}