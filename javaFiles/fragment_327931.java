public class Test {
  public static Reg reg;
  public void static main( String... args ) {
     reg = new Reg();
     synchronized( reg ) {
            // do stuff
     }
  }
}