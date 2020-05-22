public class TestObject implements Comparable{
    private int a_number;

public int getNumber() {
   return a_number;
   }

public int compareTo(TestObject other) {
   return getNumber() - other.getNumber();
   }
}