public class Main {
  public static void main(String[] args) {
    int w = 10,
    z = 20;
    MyClass m = new MyClass();
    m.swap(w,z);
    System.out.println(w + " " + z);
  }
}

public class MyClass {
    public void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }
}