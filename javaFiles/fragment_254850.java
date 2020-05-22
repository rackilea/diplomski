@Named
class CacheManagerPeerProviderConfigurationProvider implements Provider<Foo<?>> 
    { 

    @Inject
    private List<Pair<String, Integer>> peers;

    @Override
    @Bean(name = CACHE_MANAGER_PEER_PROVIDER_FACTORY)
    public Foo<?> get() { 
        return new Foo(peers);    
    }
}