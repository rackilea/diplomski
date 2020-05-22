package package1;

public class Outer {
    class Inner{
        Inner(){
            System.out.println("non-public constructor of inner class");
        }
    }
}