public class B {

    //constructor       
    public B() {
        //implicity constructor
    }

}

public class A {

    //constructor       
    public A() {
         Bb = new B(); //calls the constructor inside B during setup even if the constructor method does not exist within B an implicit constructor is made
    }

}