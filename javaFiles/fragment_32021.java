class A {}

class B extends A{  };

class C extends A{  };

public  <T extends A> T test() {        
        return (T) new B();
}