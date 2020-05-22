import java.util.regex.*;

class SOReplaceSpacesInQuotes {
  public static void main(String[] args) {
    Pattern findQuotes = Pattern.compile("\"[^\"]+\\*\"");

    for (String arg : args) {
      Matcher m = findQuotes.matcher(arg);

      StringBuffer result = new StringBuffer();
      while (m.find())
        m.appendReplacement(result, m.group().replace(" ", "\\\\ "));
      m.appendTail(result);

      System.out.println(arg + " -> " + result.toString());
    }
  }
}