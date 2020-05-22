public interface MyInterface {

    int someVar = 20;  // no error 
    int var2;  // compile time error

private int myPrivate = 30; // error - only public, static & final are permitted

    MyIterface(){  // Constructor - compile time error

    }

    MyIterface(int parameter){  // Another constructor - compile time error 
    }

    default int someMethod( int parameter){
        int someOtherVar = 30;
        someVar ++; // compile time error - someVar is a final field, cannot be modified
        return someVar+parameter;
    }
}