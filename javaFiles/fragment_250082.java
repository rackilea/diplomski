public int[] youMakeMeOdd(int [] arr) {
   List<Integer> odds = new ArrayList<Integer>();
   for(int i = 0; i < arr.length; i++)
   {
      if(arr[i] % 2 != 0)
      {
         odds.add(arr[i]);
      }
   }
   return convertIntegers(odds);
}

public static int[] convertIntegers(List<Integer> integers)
{
    int[] ret = new int[integers.size()];
    Iterator<Integer> iterator = integers.iterator();
    for (int i = 0; i < ret.length; i++)
    {
        ret[i] = iterator.next().intValue();
    }
    return ret;
}