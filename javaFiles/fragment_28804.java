public class IndexedMap
{
  public static void main(String[] args)
  {
    LinkedHashMap hm = new LinkedHashMap();
    hm.put("a",1);
    hm.put("b",2);
    hm.put("c",3);
    hm.put("d",4);
    hm.put("e",5);
    System.out.println(getNextItem(hm, "d"));
  }

  public static Object getNextItem(LinkedHashMap<String, String> hMap, String item){

    int index = 0;
    List<String> keys = new ArrayList<String>(hMap.keySet());
    for (String key : keys)
    {
      if (item.equals(key))
        break;

      index++;
    }
    return (index < keys.size() - 1) ? hMap.values().toArray()[++index] : 0;
  }

}