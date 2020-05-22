public class Parse
{
  public static void main(String[] args)
  {
    String h = " <a href=\"http://www.google.fr\">Link to google</a>";
    int n = getIndexOf(h, '"', 0);

    String[] a = h.substring(n).split(">");
    String url = a[0].replaceAll("\"", "");
    String value = a[1].replaceAll("</a", "");

    System.out.println(url + " - " + value);
  }

  public static int getIndexOf(String str, char c, int n)
  {
    int pos = str.indexOf(c, 0);
    while (n-- > 0 && pos != -1)
    {
      pos = str.indexOf(c, pos + 1);
    }
    return pos;
  }
}