import java.util.*;

public class Main {
  public static void main(String[] args) {
    List<Integer> l = new LinkedList<Integer>();
    l.add(5);
 l.add(10);
 l.add(2);
 l.add(5);
 l.add(20);

 System.err.println(freq(l));
  }

  private static <T> SortedMap<T, Integer> freq(Collection<? extends T> c) {
 SortedMap<T, Integer> ret = new TreeMap<T, Integer>();

 for (T t : c) {
     Integer fq = ret.get(t);
     ret.put(t, fq == null ? 1 : fq + 1);
 }

 return ret;
  }    
}