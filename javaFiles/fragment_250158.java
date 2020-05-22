int[] arr = {5, 4, 5, 4, 2};
ArrayList<Integer> resultArray = new ArrayList<Integer>();
Set<Integer> set = new HashSet<Integer>();

for (int i = 0; i < arr.length; i++)
    {
     if (set.contains(arr[i]))
    {
     System.out.println("Duplicate value found at index: " + i);
     System.out.println("Duplicate value: " + arr[i]);
         resultArray.add(arr[i]);
    }
    else
    {
    set.add(arr[i]);
    }
   }
Collections.sort(resultArray);

for (int i = 0; i < resultArray.size(); i++)
{
Log.e("Duplicate Values:", resultArray.get(i) + "");
}