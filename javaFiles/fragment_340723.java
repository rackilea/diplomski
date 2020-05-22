class Example1 {
    // Static class
    static class X {
        static String str = "Inside Class X";

        public void display() {
            System.out.println("I am in display method");
        }
    }

}

public class StaticInnerDemo {
    public static void main(String[] args) {
//Accessing static field of an static inner class
        Example1.X.str = "Inside Class Example1";
        System.out.println("String stored in str is- " + Example1.X.str);

//Accessing non static method of static inner class.
        Example1.X ob = new Example1.X();
        ob.display();

    }

}