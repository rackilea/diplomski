public interface Facade {
    public String getMeYourName();
    public void someOtherMethod();
}

public class Original implements Facade {
    private String name;

    Original(String name) {
        this.name = name;
    }

    public String getMeYourName() {
        return name;
    }

    public void someOtherMethod() {
        // a lot of great code
    }
}

public class Modified implements Facade {
    private Facade original;
    private String otherName;

    Modified(Facade original, String otherName) {
        this.original = original;
        this.otherName = otherName;
    }

    public String getMeYourName() {
        return otherName;
    }

    public void someOtherMethod() {
        original.someOtherMethod();
    }
}