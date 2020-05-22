import java.util.Comparator;
import java.util.TreeSet;

public class SortestSetDemo {
    public static void main(String[] args) {
        TreeSet t1 = new TreeSet(new MyComparator());
        t1.add(new StringBuffer("a"));
        // t1.add("d");
        t1.add(new StringBuffer("q"));
        t1.add(new StringBuffer("w"));
        t1.add(new StringBuffer("r"));

        System.out.println(t1);
    }

}

class MyComparator implements Comparator {
    public int compare(Object ob1, Object ob2) {

        // String i1=(String)ob1;
        String i1 = ob1.toString();
        // String i2=(String)ob2;
        String i2 = ob2.toString();
        return -i1.compareTo(i2);

    }
}