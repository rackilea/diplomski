public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ParentModule());
        ParentClass newbie = injector.getInstance(ParentClass.class);
    }
}