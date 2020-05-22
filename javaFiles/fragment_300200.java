public class Bar {
    public int getValue() {
        return 8675309;
    }
}

public class Foo {
    public String field = null;

    public Foo(Bar b) {
        this.field = "" + b.getValue();
    }

    public String getField() {
        return this.field;
    }

    public char getFirstChar() {
        return getField().charAt(0);
    }
}