install(new FactoryModuleBuilder().implement(SportsCar.class,Ferrari.class).build(FerrariFactory.class));
    install(new FactoryModuleBuilder().implement(LuxuryCar.class,Mercedes.class).build(MercedesFactory.class));



    MapBinder<String, CarFactory<?>> mapbinder = MapBinder.newMapBinder(binder(), new TypeLiteral<String>(){}, new TypeLiteral<CarFactory<?>>(){});

     mapbinder.addBinding("ferrari").to(FerrariFactory.class);  
     mapbinder.addBinding("mercedes").to(MercedesFactory.class);