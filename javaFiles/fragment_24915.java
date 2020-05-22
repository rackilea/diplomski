public interface MyInterface {//define Functional Interafce (SAM)
    public int someMethod(int a);
}

public class Test {
   public static void main(String[] args) {
        MyInterface myInterface = (int a) -> a +5;//assign the expression to SAM
        int output = myInterface.someMethod(20)); //returns 25
   }
}