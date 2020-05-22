final ApplicationContextMock appContext = new ApplicationContextMock();
appContext.putBean(mock(MyServiceA.class));
Application app = new Application() {
    public void init() {
        ...
        getComponentInstantiationListeners().add(new SpringComponentInjector(this, appContext));
    }
}
WicketTester wicketTester = new WicketTester(app);
wicketTester.startComponent(MyComponent.class);