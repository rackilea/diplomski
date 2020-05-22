public List<List<String>> combinations(List<String> strings) 
{
  if (strings.size() > 1) 
  {
    List<List<String>> result = new ArrayList<List<String>>();

    for (String str : strings) 
    {
      List<String> subStrings = new ArrayList<String>(strings);
      subStrings.remove(str);

      result.add(new ArrayList<String>(Arrays.asList(str)));

      for (List<String> combinations : combinations(subStrings)) 
      {
        combinations.add(str);
        result.add(combinations);
      }
    }

    return result;
  }
  else 
  {
    List<List<String>> result = new ArrayList<List<String>>();
    result.add(new ArrayList<String>(strings));
    return result;
  }
}