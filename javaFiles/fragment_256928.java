public class Main {
  public static void main(String[] args) throws Exception {
      SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      Date date = sdfSource.parse("2011-07-17 08:05:50");
      SimpleDateFormat sdfDestination = new SimpleDateFormat("MMM dd hh:mma");
      System.out.println(sdfDestination.format(date));
  }
}