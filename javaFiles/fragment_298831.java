import java.util.ArrayList;

class GrandParent {
// codes here
}


abstract class Parent1 extends GrandParent {
// codes here
}

class A extends Parent1 {
// codes here
}

class B extends Parent1 {
// codes here
}



public class Main {

    public static ArrayList<GrandParent> gps;

    public static void main (String [] args) {
       gps = new ArrayList<>();    

       gps.add(new A());
       gps.add(new B());


    }

    public static void method () {
       if(gps.get(0) instanceof Parent1) {   // in here i get an error that says inconvertible types; cannot cast GrandParent to java.util.Parent1
           {
             //Codes here 
           }

       }
    }
}