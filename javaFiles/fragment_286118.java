public class SingletonA implements InterestingInterface {

    private static SingletonA instance = null;

    private SingletonA(){}

    public static SingletonA getInstance() {
        if (instance == null) {
            instance = new SingletonA();
        }

        return instance;
    }

    @Override
    public void print() {
        System.out.println("I am A");
    }
}

class SingletonB implements InterestingInterface {
    private static SingletonB instance = null;

    private SingletonB(){}

    public static SingletonB getInstance() {
        if (instance == null) {
            instance = new SingletonB();
        }

        return instance;
    }

    @Override
    public void print() {
        System.out.println("I am B");
    }
}

public class C implements InterestingInterface {
    @override
    public void print() {
        System.out.println("I am C");
    }
}