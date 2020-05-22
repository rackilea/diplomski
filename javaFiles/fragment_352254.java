public class Global extends GlobalSettings {

    private static final Injector INJECTOR = createInjector();  

   /**
     * Need for injection.
     *
     * @param controllerClass
     * @param <A>
     * @return
     * @throws Exception
     */
    @Override
    public <A> A getControllerInstance(Class<A> controllerClass) throws Exception {
        return INJECTOR.getInstance(controllerClass);
    }

    private static Injector createInjector() {
        return Guice.createInjector();
    }
}