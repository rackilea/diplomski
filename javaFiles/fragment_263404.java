import java.util.ArrayList;
import java.util.Iterator;

class Human<T>{
  public void al(ArrayList<? super Person> a){
    Iterator<? super Person> iter = a.iterator();
    while (iter.hasNext()) {
      Person h = (Person) iter.next(); // unsafe cast
    }
  }
}

public class Person {
  public static void main(String[] args) {
    Human h = new Human();

    ArrayList<String> arr = new ArrayList<String>();
    arr.add("deadbeef");

    h.al(arr); // valid, since h is raw
  }
}