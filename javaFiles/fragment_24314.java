@Singleton
public class RequestUrlRepository implements Provider<IRequestUrlRepository> {

    @Inject Provider<CostRequestUrlRepository> costRepositoryProvider;
    @Inject Provider<RoutingRequestUrlRepository> routingRepositoryProvider;
    @Inject Injector injector;

    @Override public IRequestUrlRepository get() {
        IRequestUrlRepository answer = null;
        if (System.getProperty("").equals(RouteOrCostRequest.cost.toString())){
            return costRepositoryProvider.get();
        } else {
            return routingRepositoryProvider.get();
        }

        // Alternatively:
        return injector.getInstance(Class.forName(System.getProperty("")));
    }
}