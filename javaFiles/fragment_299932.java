public class CustomComparator implements Comparator<FXNode> {
    static Map<Class<? extends FXNode>,Integer> priorities = new HashMap<>();
    static {
        priorities.put(Node1.class,2);
        priorities.put(Node2.class,1);
    }

    @Override
    public int compare(FXNode o1, FXNode o2) {
        return Integer.compare(priorities.get(o1.getClass()),priorities.get(o1.getClass()));
    }   
}