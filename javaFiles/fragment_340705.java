public class SpeedComparison
{
  private static String extractUser(String aS)
  {
    int start = aS.indexOf('[') + 1;
    int end = aS.indexOf(']');

    return aS.substring(start, end);
  }


  static Map<String, Integer> group(List<String> aList)
  {
    Map<String, Integer> results = new HashMap<>();

    for (String s : aList)
    {
      String extract = extractUser(s);
      int count = results.getOrDefault(extract, 0) + 1;
      results.put(extract, count);
    }

    return results;
  }

  final static Pattern pattern = Pattern.compile("\\[(.*)\\]");
  static Optional<String> parseValue(String raw) {
    Matcher m = pattern.matcher(raw);
    if (m.find()) {
      return Optional.of(m.group(1));
    } else {
      return Optional.empty();
    }
  }

  public static void main(String[] args)
  {

    List<String> list = new ArrayList<>();

     for (int i = 0; i< 100000 ; ++i)
     {
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
     }


    //Test basic
    final long start1 = System.currentTimeMillis();
    group(list);
    final long dur1 = System.currentTimeMillis() - start1;

    //Test streams
    final long start2 = System.currentTimeMillis();
    list.stream().map(s -> parseValue(s).orElse("missing")).collect(Collectors.groupingBy(
      Function.identity(), Collectors.counting()
    ));
    final long dur2 = System.currentTimeMillis() - start2;

    System.out.println("Speed Comparison");
    //prints ~100, ~1000 milliseconds (10x slower with streams)
    System.out.printf("Test 1: %s%nTest 2: %s",dur1,dur2);
  }
}