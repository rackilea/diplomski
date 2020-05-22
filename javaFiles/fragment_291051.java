Set<String> keySet = new HashSet<String>();
for (Map.Entry<String, String> entry : map.entrySet())
{
    if(entry.getValue().equals("value2")
    {
      keySet.add(entry.getKey());
    }

}