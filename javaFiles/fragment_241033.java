public class MyComparator implements Comparator<Integer> {
   public int compare(Integer a, Integer b) {
      //
   }

   //THIS is a "bridge method"
   public int compare(Object a, Object b) {
      return compare((Integer)a, (Integer)b);
   }
}