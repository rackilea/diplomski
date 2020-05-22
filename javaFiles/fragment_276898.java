public class PrivateModuleTest {
    public static interface Admin {}

    public static class AdminImpl implements Admin {
        @Inject
        public AdminImpl(BusLogic x) {}
    }

    public static interface BusLogic {}

    public static class BusLogicImpl implements BusLogic {}

    public static class AdminModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(Admin.class).to(AdminImpl.class);
        }
    }

    public static class BusLogicModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(BusLogic.class).to(BusLogicImpl.class);
        }
    }

    public static class AppModule extends PrivateModule {
        @Override
        protected void configure() {
            install(new AdminModule());
            expose(Admin.class);  // <---- clients may instantiate only this type

            install(new BusLogicModule());
        }
    }

    @Test
    public void exposeAdmin() {
        Guice.createInjector(new AppModule())
                .getInstance(Admin.class);
    }

    @Test(expected = ConfigurationException.class)
    public void doNotExposeBusLogic() {
        Guice.createInjector(new AppModule())
                .getInstance(BusLogic.class);
    }
}