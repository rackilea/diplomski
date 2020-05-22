@Mock
private TestActionHandler mockTestActionHandler;
@Mock
private HttpServletRequest servletRequest;

@Before
public void setUp() {
    Injector injector = Guice.createInjector(new ServerModule(), new MockHandlerModule() {

        @Override
        protected void configureMockHandlers() {
                bindMockActionHandler(TestActionHandler.class, 
                        mockTestActionHandler);
            }
        });

        @SuppressWarnings("unused")
        @Provides 
        public HttpServletRequest createServletRequest() { 
            return servletRequest; 
        } 
}