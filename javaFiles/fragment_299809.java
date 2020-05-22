class Foo{

    private InitialLoadMode initialLoadMode = InitialLoadMode.EAGER;
    final Config config= new Config();
    final MapConfig mapConfig = config.getMapConfig("*");
    final MapStoreConfig mapStoreConfig = mapConfig.getMapStoreConfig();
    {
        mapStoreConfig.setInitialLoadMode(initialLoadMode);
    }
}