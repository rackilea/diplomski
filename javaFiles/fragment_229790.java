public static void main(String[] args) throws Throwable {
    ClassPool cp = ClassPool.getDefault();
    Loader cl = new Loader(cp);
    cl.addTranslator(cp, new PrintArgumentsTranslator());
    cl.run("test.Test$MyApp", args);  // or whatever class you want to start with
}

public class MyApp {

    public MyApp() {
        System.out.println("Inside: MyApp constructor");
    }

    public static void main(String[] args) {
        System.out.println("Inside: main method");
        new MyApp().method("Hello World!", 4711);
    }

    public void method(String string, int i) {
        System.out.println("Inside: MyApp method");
    }
}