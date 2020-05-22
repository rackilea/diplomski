public interface Context {

    void print();

}


public class ContextHolder<T extends Context> {

    private T context;

    public ContextHolder(T context) {
        this.context = context;
    }

    public T getContext() {
        return context;
    }

    public void print() {
        context.print();
    }

    public void foo() {

    }

}


public class ContextA implements Context {

    @Override
    public void print() {
        System.out.println("In context A");
    }

    public void doSomeA() {
        System.out.println("Do some A");
    }
}


public class ContextB implements Context {

    @Override
    public void print() {

    }

    public void doSomeB() {
        int a = 1;
        System.out.println(a);
    }

}

public abstract class AbstractFactory<T extends Context> {

    public abstract ContextHolder<T> createContext();

}

public class FactoryA extends AbstractFactory<ContextA> {

    @Override
    public ContextHolder<ContextA> createContext() {
        return new ContextHolder<ContextA>(new ContextA());
    }

}

public class FactoryB extends AbstractFactory<ContextB> {

    @Override
    public ContextHolder<ContextB> createContext() {
        return new ContextHolder<ContextB>(new ContextB());
    }

}

public class FactoryMaker {

    private static AbstractFactory factory = null;

    public static AbstractFactory getFactory(String condition) {
        if (condition == "A") {
            factory = new FactoryA();
        } else {
            factory = new FactoryB();
        }

        return factory;
    }
}


 public static void main(String[] args) {
        ContextHolder<ContextA> contextHolderA = FactoryMaker.getFactory("A").createContext();
        contextHolderA.print();    
        contextHolderA.getContext().doSomeA();

        ContextHolder<ContextB> contextHolderB = FactoryMaker.getFactory("").createContext();
        contextHolderB.print(); 
        contextHolderB.getContext().doSomeB();
    }