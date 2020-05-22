public List<List<String>> combinations(List<String> strings) 
{
  if (strings.size()> 1) 
  {
    ...
  }
  else 
  {
    List<List<String>> result = new ArrayList<List<String>>();
    result.add(strings);
    return result;
  }
}