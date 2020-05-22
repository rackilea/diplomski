public abstract class EdumateSuperClass {
    protected abstract void childMethod(String message);

    public void callChildMethod() {
        childMethod("hello");
    }
}

public abstract class Navigation extends EdumateSuperClass {
    protected void childMethod(String message) {
        System.out.println(message);
    }
}