import java.util.HashMap;

public class CountOccur
{
  public static void main(String[] args)
  {
    Integer[] arr = new Integer[]{2,4,0,7,4,2,1,0};
    HashMap<Integer, Integer> countMap = count(arr);

    for (Integer key : countMap.keySet()) {
      System.out.println(key + " count: " + countMap.get(key));
   }

  }

  public static HashMap<Integer, Integer> count(Integer[] nums)
  { 
      HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();

      for (int i = 0; i < nums.length; ++i)
      {
          Integer count = countMap.get(nums[i]); 
          if (count  == null){
            //first occurrence, enter a value of 1 for count
            countMap.put(nums[i], 1);
          }
          else{
            //already in the HashMap, increment the count
            countMap.put(nums[i], count + 1);
          }

      }

      return countMap;
  }
}