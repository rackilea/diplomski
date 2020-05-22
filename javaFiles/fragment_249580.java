public class Client {

    public void putTheActTogether() {
        ConcreteC theC = new ConcreteC();

        // the concrete A
        AbstractA theA = new AbstractA() {
            @Override
            public AbstractB createB() {
                return new ConcreteB(theC);
            }
        };
        // call methods in theA
    }

}

public class ConcreteB extends AbstractB {

    private final ConcreteC c;

    public ConcreteB(ConcreteC c) {
        super();
        this.c = c;
    }

    public void bar() {
        c.concreteCMethod();
    }

}

public class ConcreteC {

    public void concreteCMethod() { // was concreteAMethod(); moved and renamed
        // ...
    }

}