class X{
    private int field = 1;
    private void method(){}
    void foo(X x){
        x.field = 2;
        x.method(); // this is OK, because we are accessing members from instance of X 
                    // via reference of class X (which is same class as this one)
    }

    void bar(Y y){// = lets assume that Y extends X
        y.field = 3;
        y.method(); // ERROR: we can't access `method()` 
    }
}