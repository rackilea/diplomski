import  java.util.ArrayList;
  import  java.util.Arrays;
  import  java.util.Iterator;
  import  java.util.List;
  import  java.util.Map;
  import  java.util.TreeMap;
/**
   <P>{@code java SortOneArrayKeepSecondArrayElementsAligned}</P>
 **/
public class SortOneArrayKeepSecondArrayElementsAligned  {
   public static final void main(String[] ignored)  {
      int[][] intArrayArray = new int[][]{
        { 6, 3, 1, 2, 3, 0},
        { 2, 1, 6, 6, 2, 4}};
      output2DArray("Unsorted", intArrayArray);

      Map<Integer,List<TwoInts>> twoIntMap = new TreeMap<Integer,List<TwoInts>>();
      for(int i = 0; i < intArrayArray[0].length; i++)  {
         int intIn0 = intArrayArray[0][i];
         if(!twoIntMap.containsKey(intIn0))  {
            List<TwoInts> twoIntList = new ArrayList<TwoInts>(intArrayArray.length);
            twoIntList.add(new TwoInts(intArrayArray[0][i], intArrayArray[1][i]));
               twoIntMap.put(intIn0, twoIntList);
         }  else  {
            twoIntMap.get(intIn0).add(new TwoInts(intArrayArray[0][i], intArrayArray[1][i]));
         }
      }

      int idx = 0;
      Iterator<Integer> itr2i = twoIntMap.keySet().iterator();
      while(itr2i.hasNext())  {
         List<TwoInts> twoIntList = twoIntMap.get(itr2i.next());
         for(TwoInts twoi : twoIntList)  {
            intArrayArray[0][idx] = twoi.aElement;
            intArrayArray[1][idx++] = twoi.bElement;
         }
      }

      output2DArray("Sorted", intArrayArray);
   }
   private static final void output2DArray(String description, int[][] twoD_array)  {
      System.out.println(description + ":");
      System.out.println("0: " + Arrays.toString(twoD_array[0]));
      System.out.println("1: " + Arrays.toString(twoD_array[1]));
      System.out.println();
   }

}
class TwoInts  {
   public final int aElement;
   public final int bElement;
   public TwoInts(int a_element, int b_element)  {
      aElement = a_element;
      bElement = b_element;
   }
}