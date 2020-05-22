public class StackOverflow
{
  private static final String testString = "CH3O2";

  public static void main(String[] args)
  {
    List<String> terms = new ArrayList<String>();
    for (int i = 0; i < testString.length(); i++)
    {
      if (Character.isUpperCase(testString.charAt(i)))
      {
        if (i + 1 < testString.length()
            && Character.isDigit(testString.charAt(i + 1)))
        {
          terms.add(testString.charAt(i) + "," + testString.charAt(i + 1));
          i++;
          continue;
        }
        terms.add(testString.charAt(i) + ",1");
      }
    }
    for (String s : terms)
    {
      System.out.println(s);
    }
  }
}