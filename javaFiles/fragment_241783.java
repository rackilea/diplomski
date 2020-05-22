public class Test {
  public static void main(String... args) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    try {
      long qu = dateFormat.parse("24/12/2011 18:54:23").getTime();
      Timestamp ts = new Timestamp(qu);
      System.out.println(ts);
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
}