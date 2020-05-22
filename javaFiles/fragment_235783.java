abstract class A {
    abstract public cpVect[][] getPoints();

    // more methods ...
}

public class B extends A {

    private final static cpVect[][] POINTS = calculatePoints();

    @Override
    public cpVect[][] getPoints() {
        return POINTS;
    }

    private cpVect[][] calculatePoints() {
        // ...
    }
}