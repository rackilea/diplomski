public class Test{

   public static void main(String[] args) {
      String s = new String("ABCDf");
      System.out.println(s);
      int length = s.length();
      int mid = length / 2;
      s = (length % 2 != 0) ? (s.substring(0, mid) + s.substring(mid + 1, 
      s.length())) : (s.substring(0, mid - 1) + s.substring(mid + 1, s.length()));
      System.out.println(s);
  }

}