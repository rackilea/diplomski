public class Sort2D {
  public static void main(String args[]) {
    String ss[][] = { 
      {"Home", "0.1256784"},
      {"Contact", "-0.56789"},
      {"Refer", "1.36589"},
      {"Next", "3.678456"}
    };
    Arrays.sort(ss, new Comparator<String[]>() {
      public int compare(String[] s1, String[] s2) {
        double d1 = Double.parseDouble(s1[1]);
        double d2 = Double.parseDouble(s2[1]);
        return Double.compare(d1, d2);
      }
    });
    for (String[] s : ss) {
      System.out.println(s[0] + ": " + s[1]);
    }
  }
}