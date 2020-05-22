public class Example
{

  private static String extractDate(String aS)
  {
    int end = aS.indexOf('[');
    return aS.substring(0, end).trim();

  }

  private static String extractUser(String aS)
  {
    int start = aS.indexOf('[') + 1;
    int end = aS.indexOf(']');

    return aS.substring(start, end);

  }

  private static String extractMessage(String aS)
  {
    int start = aS.indexOf("]") + 1;
    if (aS.length() > start)
    {
      return aS.substring(start).trim();
    } else
    {
      return "";
    }
  }

  static Map<String, Integer> group(List<String> aList, Function<String, String> aExtractor)
  {
    Map<String, Integer> results = new HashMap<>();

    for (String s : aList)
    {
      String extract = aExtractor.apply(s);
      int count = results.getOrDefault(extract, 0) + 1;
      results.put(extract, count);
    }

    return results;
  }

  static void printMap(Map<String, Integer> aStringIntegerMap)
  {
    for (Map.Entry<String, Integer> entry : aStringIntegerMap.entrySet())
    {
      System.out.printf("%s: %s%n", entry.getKey(), entry.getValue());
    }
  }

  public static void main(String[] args)
  {

    List<String> list = new ArrayList<>();

    list.add("10/10/2012 [user2] some message1");
    list.add("10/10/2012 [user1] some message2");
    list.add("10/10/2012 [qwwww] some message3");
    list.add("11/10/2012 [user3] some message4");
    list.add("11/10/2012 [user3] some message5");
    list.add("12/10/2012 [user2] some message6");
    list.add("12/10/2012 [user3] some message7");
    list.add("12/10/2012 [user2] some message8");
    list.add("12/10/2012 [sdsds] some message9");
    list.add("12/10/2012 [user2] some message10");

    //Note: use of lamdas here can impact performance.
    printMap(group(list, Example::extractUser)); 

    printMap(group(list, Example::extractDate));

    printMap(group(list, Example::extractMessage));

  }
}