public class Driver
{
  static public void main(String[] args)
  {
    String t = new String("SOME_TEXT,+09:30:01.040910105,SOME_TEXT,SOME_TEXT,SOME_TEXT");
    Pattern regex = Pattern.compile("(\\d\\d):(\\d\\d):(\\d\\d)\\.(\\d{9})");
    Matcher matcher = regex.matcher(t);
    while (matcher.find()) {
        for (int i=1; i<=matcher.groupCount(); ++i)
        {
          System.out.println(matcher.group(i));
        }
    }
  }
}