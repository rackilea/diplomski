public class MyComparator implements Comparator<Call> {

   @Override
   public int compare(Call c1, Call c2) {
      int firstCompare = Integer.compare(c1.getValue1(), c2.getValue1());
      if (firstCompare != 0) {
         return firstCompare;
      } else {
         return Integer.compare(c1.getValue2(), c2.getValue2());
      }
   }

}