import java.util.ArrayList;

public class Test<T> {
  ArrayList<T> yourArray;

  Test() {
    // Initialize to avoid NPEs
    yourArray = new ArrayList<T>();
  }

  public void addToFront(T element) {
    yourArray.add(0, element);
  }

  public void addToRear(T element) {
     yourArray.add(yourArray.size(), element);
  }

  public void addAfter(T element, T target) {
     yourArray.add(yourArray.indexOf(target) + 1, element);
  }

  public void addBefore(T element, T target) {
     final int location = yourArray.indexOf(target);

     if (location == 0) {
       addToFront(element);
     } else {
       yourArray.add(yourArray.indexOf(target) - 1, element);
     }
  }
}