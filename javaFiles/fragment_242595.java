public class Main {

    public static void main(String[] args) {
        staticAction(new MyClass());
        staticAction(new MyOtherClass());
    }

    public static <T extends JComponent & MyInterface> void staticAction(T bar) {
        bar.interfaceMethod();
        System.out.println(bar.getWidth());
    }
}