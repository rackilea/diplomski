private static final java.text.SimpleDateFormat sdf = 
    new java.text.SimpleDateFormat("yyyyMMdd");

public static java.util.Date verifyInput(String input) {
  if (input != null) {
    try {
      java.util.Date ret = sdf.parse(input.trim());
      if (sdf.format(ret).equals(input.trim())) {
        return ret;
      }
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
  return null;
}

public static void main(String[] args) {
  String[] dates = new String[] { "20141031",
      "20130228", "20000229", "20000230" };
  for (String str : dates) {
    System.out.println(verifyInput(str));
  }
}