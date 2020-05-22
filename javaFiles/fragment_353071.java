Injector injector = Guice.createInjector( new AbstractModule() {
    @Override
    protected void configure() {
        bind( MyClass.class ).toInstance( mock(MyClass.class) );
        bind( AnotherClass.class ).toInstance( mock(AnotherClass.class) );
    }
} );
//Create new instance of class  that needs injections
ThirdClass thirdInstance = injector.getInstance( ThirdClass.class );