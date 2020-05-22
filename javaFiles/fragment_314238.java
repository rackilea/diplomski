public class UseInject {

    @Inject
    private double pi;  // 3.14159 will be injected here

    // the rest of the code

    public static void main(...) {
        // ....
        UseInject ui = container.instance().select(UseInject.class).get();
        ui.show();
        System.out.println(ui.pi);
        // ...
    }