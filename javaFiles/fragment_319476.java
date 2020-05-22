@BeforeMethod
public void setup() {
    MockitoAnnotations.initMocks(this);

    mockedAuthentication = mock(Authentication.class);
    mockedSecurityContext = mock(SecurityContext.class);
    originalSecurityContext = SecurityContextHolder.getContext();
    SecurityContextHolder.setContext(mockedSecurityContext);
}

@AfterMethod
public void teardown() {
    Mockito.reset(mockedAuthentication);
    Mockito.reset(mockedSecurityContext);
    SecurityContextHolder.setContext(originalSecurityContext);
}