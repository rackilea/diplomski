public class StateTest {
   public static void main(String[] args) {
      State illinois = new State("Illinois"); 
      illinois.addCity("Chicago");
      illinois.addCity("Peoria");
      illinois.addCity("Springfield");

      System.out.println(illinois);
   }
}