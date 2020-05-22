public class BusinessLogicModule {
    @Override
    protected void configure() {
        // create empty map binder
        MapBinder<String, ServiceClientAdapter> mapBinder =
                MapBinder.newMapBinder(
                        binder(), String.class, ServiceClientAdapter.class);

        // bind different impls, keyed by descriptive strings
        mapBinder.addBinding("legacy")
                .to(MyLegacyServiceClientAdapterImpl.class);
        mapBinder.addBinding("new")
                .to(MyNewServiceClientAdapterImpl.class);
    }
}