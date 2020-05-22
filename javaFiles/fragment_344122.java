public class NestedFor {

  public static void main(String[] args) {
    for(int i=1; i<=7; i++) {
      for(int j=1; j<i; j++) {
        if (i + j == 7 ) {
          System.out.println(i+ "   " +j);
        }
      }
     }
   }
}