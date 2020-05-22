// Let's define a generic class.
public class Cell<T> {
  public void set(T t) { this.t = t; }
  public T get() { return t; }

  private T t;
}

public class A {

  static Cell<String> cell = new Cell<String>();  // Instantiate it.

  public static void main(String[] args) {
    // Now, let's use it.
    cell.set("a");
    String s = cell.get(); 
    System.out.println(s);
  }  
}