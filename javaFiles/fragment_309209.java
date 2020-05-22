public class Clidlet extends Clidder {

  @Override public final void flipper() {
    System.out.println("Clidlet");
  }

  public static void main(String[] args) {
    new Clidlet().flipper();
  }

}