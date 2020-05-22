public class Main {
    @Inject
    private MyFactory factory;

    public void run() {
        ParentClass newbie = new ParentClass(factory);
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ParentModule());
        Main main = injector.getInstance(Main.class);
        main.run();
    }
}