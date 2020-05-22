public static void main(String[] args) 
{
  List<List<Integer>> integers = new ArrayList<List<Integer>>();
  integers.add(Arrays.asList(1, 3, 4));
  integers.add(Arrays.asList(2, 6));
  integers.add(Arrays.asList(0));

  List<List<Integer>> combinations = combine(integers);

  System.out.println(combinations);
}

private static List<List<Integer>> combine(List<List<Integer>> allIntegers) 
{
  List<Integer> integers = allIntegers.remove(0);
  List<List<Integer>> allCombinations = new ArrayList<List<Integer>>();

  for (Integer i : integers) 
  {
    if (allIntegers.isEmpty()) 
    {
      allCombinations.add(new ArrayList<Integer>(Arrays.asList(i)));
    }
    else 
    {
      for (List<Integer> combinations : combine(new ArrayList<List<Integer>>(allIntegers))) 
      {
        combinations.add(0, i);
        allCombinations.add(combinations);
      }
    }
  }

  return allCombinations;
}