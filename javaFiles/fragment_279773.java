protected void configure() {
    MapBinder<String, IService> mapBinder 
        = MapBinder.newMapBinder(binder(), String.class, IService.class);
    mapBinder.addBinding("keyA").to(IServiceA.class);
    mapBinder.addBinding("keyB").to(IserviceB.class);
}