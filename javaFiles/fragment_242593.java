public class Foo<T extends JComponent & MyInterface> {

    private T bar;

    public Foo(T bar) {
        this.bar = bar;
    }

    public void fooAction() {
        bar.interfaceMethod(); // MyInterface method
        System.out.println(bar.getWidth()); // JComponent method
    }
}