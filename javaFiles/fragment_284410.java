public class Super {
    public  void method() {
        System.out.println("Super");
    }
}

public class Sub extends Super {
    public  void method() {
        System.out.println("Sub");
    }
}
//in a main method somewhere
Super instance = new Sub();
instance.method();