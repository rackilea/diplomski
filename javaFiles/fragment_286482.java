@Override
public void configure() {
    bindFactory(MagicWrapperFactory.class)
        .to(MagicWrapper.class)
        .proxy(true)
        .proxyForSameScope(false)
        .in(RequestScoped.class);
}