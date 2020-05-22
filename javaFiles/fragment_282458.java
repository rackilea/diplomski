public class SqlLoaderTest
  {
  public static void main(String[] args) {
    try {
        String sqlldrCmd = "sqlldr username/pwd, control=trial.ctl";

        System.out.println("SQLLDR Started ....... ");
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec(sqlldrCmd);
        System.out.println("SQLLDR Ended ........  ");
      } catch (Exception e) {
        e.printStackTrace();
    }
   }
  }