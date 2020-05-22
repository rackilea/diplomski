Set<Integer> allNumbers = new HashSet<>();
for (int i = 1; i < 6; i++)
{
  Set<Integer> set = new HashSet<>();
  while (set.size() < 6)
  {
    int random = (int) (Math.random() * 49 + 1);
    if (allNumbers.add(random))
    {
      set.add(random);
    }
  }
  Integer[] array = set.toArray(new Integer[] {});
  Arrays.sort(array);
  System.out.println(Arrays.toString(array));  
}