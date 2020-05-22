public class Test {

    private int item;

    public Test() {
        this(0); // Default to 0
    }

    public Test(int item) {
        setItem(item);
        test();
    }

    public void test() {
        System.out.println(getItem());
    }

    public static void main(String[] args) {
        Subclass s = new Subclass();
        s.test();
    }

    public void setItem(int item) {
        this.item = item;
    }    

    public int getItem() {
        return item;
    }

}

class Subclass extends Test {

  public Subclass() {
      super(1); // Default to 1
  }

}