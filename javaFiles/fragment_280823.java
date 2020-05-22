public class MyMainClass {
    public static void main(final String[] args) {
        final MyMainClass clazz = new MyMainClass();
        clazz.echo(new Example());
    }

    public Example echo(@Valid final Example example) {
        // ...
    }
}