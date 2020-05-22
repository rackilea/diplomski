public class CME {
    public static void main(String...args) {
        HashSet<Integer> coll = new HashSet<Integer>();
        coll.add(1);
        coll.add(2);
        coll.add(3);

        for(Integer i : coll) {
            coll.remove(i); // Throws ConcurrentModificationException
        }
    }
}