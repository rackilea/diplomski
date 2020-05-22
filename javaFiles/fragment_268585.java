public class Main {
  public static void main(String... args) {
    ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime()
        .availableProcessors());
    Function a = new Function("A", service);
    Function b = new Function("B", service);
    Function c = new Function("C", service);
    a.addObserver(b);
    a.addObserver(c);

    Func d = new ShutdownFunc("D", service);
    c.addObserver(d);

    a.change();
  }
}