public interface Foo {
    Object doSomething(String input) throws IOException;
}

public interface Bar extends Foo {
    @Override
    String doSomething(String input);
}