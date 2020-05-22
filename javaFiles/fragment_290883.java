// X.java

public class X {
    private Y y = new Y();
}

class Y {
    Y () {
        // if this were private, X wouldn't be able to create an instance of Y
    }
}