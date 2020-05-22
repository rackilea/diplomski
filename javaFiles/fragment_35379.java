public class Json {

  /**
   * Convertit une date Json en java.util.Date
   * @param jsonDate
   * @return
   */
  public static Date JsonDateToDate(String jsonDate)
  {
    //  "/Date(1321867151710+0100)/"
    int idx1 = jsonDate.indexOf("(");
    int idx2 = jsonDate.indexOf(")") - 5;
    String s = jsonDate.substring(idx1+1, idx2);
    long l = Long.valueOf(s);
    return new Date(l);
  }
}