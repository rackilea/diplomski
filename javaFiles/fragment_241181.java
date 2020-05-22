import java.util.regex.*;

class URLDate {
  public static void
  main(String[] args) {
    String text = "http://e.com/data/invoices/2010/09/invoices-report-wednesday-september-1st-2010.html";
    String regex = "http://e.com/data/invoices/(\\d{4})/(\\d{2})/\\D+(\\d{1,2})";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(text);
    if (m.find()) {
      int count = m.groupCount();
      System.out.format("matched with groups:\n", count);
      for (int i = 0; i <= count; ++i) {
          String group = m.group(i);
          System.out.format("\t%d: %s\n", i, group);
      }
    } else {
      System.out.println("failed to match!");
    }
  }
}