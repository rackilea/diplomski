class A{
    private A(){} //private constructor

    private static A a = new A(); //you can create A object as a field

    void test(){
        new A(); // you can create A object inside methods of your class
    }

    class Inner{ // inner classes are also members of class so you can use 
                 // A constructor here
        A a = new A(); //OK
        void test(){
            new A(); //OK
        }
    }
}

class B{
    new A();//error: we don't have access to A constructor
}