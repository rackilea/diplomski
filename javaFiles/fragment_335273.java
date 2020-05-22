public class DynamicComparator implements Comparator<Object> {
    private final String type;
    // pass in type capitalised, eg "Name" 
    // ie the getter method name minus the "get"
    public DynamicComparator (String type) {
        this.type = type;
    }
    public int compare(Object o1, Object o2) {
        // try-catch omitted 
        Method m = o1.getClass().getMethod("get" + type);
        String s1 = (String)m.invoke(o1);
        String s2 = (String)m.invoke(o2);
        return s1.compareTo(s2);
    }
}