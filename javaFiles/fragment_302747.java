abstract class Foo {
    public abstract void method(List<String> xs);
}

class Bar extends Foo {
    @Override
    public void method(List xs) {
    }
}