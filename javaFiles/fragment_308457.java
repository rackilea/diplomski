import com.google.common.collect.TreeMultiset;

public class TreeMultiSetTest { 
  public static void main(String[] args) {
    TreeMultiset<Integer> ts = TreeMultiset.create();
    ts.add(1);  ts.add(0); ts.add(2);
    ts.add(-1); ts.add(5); ts.add(2);

    for (Integer i : ts) {
      System.out.println(i);
    } 
  } 
}