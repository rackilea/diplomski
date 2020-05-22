public class A{
    private long id;

    public abstract boolean isB();
    public abstract boolean isC();
    public abstract String getBProperty();
    public abstract String getCProperty();
}

public class B extends A{
    private String bProperty;

    public boolean isB() {
        return true;
    }

    public boolean isC() {
        return false;
    }

    public String getBProperty() {
        return bProperty;
    }

    public String getCProperty() {
        throw new IllegalStateException("I'm not a C");
    }
}