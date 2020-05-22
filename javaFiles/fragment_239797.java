class A {
    // This is the super-class.
    public void myMethod() {...};
}

class B extends A { 
    // This extends above says: B is sub-class of A.
    // So this class B is the sub-class of A.
    // You can override methods of A here, like this
    public void myMethod() {...};
    // but you're not required to override them. 
}