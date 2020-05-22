public class Foo {
    private final Dependency dependency;

    public Foo(Dependency dependency) {
        if(dependency == null) {
            throw new IllegalArgumentException("dependency must be set message.");
        }
        this.dependency = dependency;
    }

// the rest of the code here.
}