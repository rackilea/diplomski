new ResourceConfig()
        .register(new AbstractBinder(){
            @Override
            public void configure() {
                bind(PathInterceptionService.class)
                        .to(InterceptionService.class)
                        .in(Singleton.class);
                    bind(LoggingConstructorInterceptor.class)
                        .to(ConstructorInterceptor.class)
                        .in(Singleton.class);
            }
        });