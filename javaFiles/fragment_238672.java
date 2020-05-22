public class Foo implements IFoo, IBar{

    public static void main(String[] args) {
        Foo foo = new Foo();
        ((IFoo) foo).print();
        ((IBar) foo).print();
    }

    @Override
    public void print() {
        System.out.println("Hello, World!");
    }
}

public interface IBar {
    void print();
}

public interface IFoo {
    void print();
}