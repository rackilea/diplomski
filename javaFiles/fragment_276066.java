public class MyObject {

    private final OtherObjectFactory factory;

    public MyObject(OtherObjectFactory factory) {
        this.factory = factory;
    }

    public void callMethod(int i) {
        factory.createOtherObject(i).doSomething();
    }
}

public abstract class OtherObject{
    public abstract void doSomething();
}

public class OtherObjectFactory {
    public OtherObject createOtherObject(int i){
        switch (i) {
        case 0:
            return new MethodAImpl();
        case 1:
            return new MethodBImpl();
        }
    }
}