@Override
public void configure() {
    bindFactory(TenantDatastoreFactory.class)
            .proxy(true)
            .proxyForSameScope(false)
            .to(Datastore.class)
            .in(RequestScoped.class);
    bind(TenantDatastoreInjectionResolver.class)
            .to(new TypeLiteral<InjectionResolver<TenantDatastore>>() {
            })
            .in(Singleton.class);
}