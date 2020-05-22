public class PublicClass {
  Innerclass array_inner[];

  class Innerclass {
    private int x;

    Innerclass(int x) {
      this.x = x;
    }
  }

  public PublicClass() {
    array_inner = new Innerclass[5];
  }

  public void access_x() {
    System.out.println(array_inner[0].x);
  }

  public static void main(String[] args) {
    PublicClass publicClass = new PublicClass();
    publicClass.array_inner[0] = publicClass.new Innerclass(0);
    publicClass.access_x();
  }
}