// Create temp list
List<Integer> secondList = new ArrayList<Integer>();
// add all sublist to temp list
for(ArrayList<Integer> subList : lists)
{
   secondList.addAll(subList);
}
// convert temp list to array
Integer[] second = secondList.toArray(new Integer[secondList.size()]);