static public class Base { 
    public void foo() { 
        System.out.println("I am base");
    }
}
static public class A extends Base { 
    @Override
    public void foo() { 
        System.out.println("I am A");
    }
}
static public class B extends Base { 
    @Override
    public void foo() { 
        System.out.println("I am B");
    }
}

    public static void main(String[] args) {
        Base[] arr = new Base[2];
        arr[0] = new A();
        arr[1] = new B();
        arr[0].foo();
        arr[1].foo();
    }