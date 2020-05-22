// RunWith needed for powermock
@RunWith(PowerMockRunner.class)
@PrepareForTest({ HttpTest.class, Foo.class, SSLContext.class, URL.class })
public class MyTestClass {

    @Test
    public void shouldSetTestMockServeField() throws Exception {
        URL u = PowerMockito.mock(URL.class);
        String url = "https://localhost";
        // mock URL constructor
        PowerMockito.whenNew(URL.class).withArguments(Matchers.anyString()).thenReturn(u);
        // mock openConnection() method
        HttpsURLConnection huc = Mockito.mock(HttpsURLConnection.class);
        Mockito.when(u.openConnection()).thenReturn(huc);

        // create mocks for Foo class
        HostnameVerifier hnameMock = Mockito.mock(HostnameVerifier.class);
        SSLContext context = PowerMockito.mock(SSLContext.class);
        SSLSocketFactory mockSocFac = Mockito.mock(SSLSocketFactory.class);
        Mockito.when(context.getSocketFactory()).thenReturn(mockSocFac);

        // mock Foo static methods to return mocks created above
        PowerMockito.mockStatic(Foo.class);
        Mockito.when(Foo.getHostnameVerifier()).thenReturn(hnameMock);
        Mockito.when(Foo.getSslContext()).thenReturn(context);

        // call static method, code will use mocked objects
        // Foo static methods will return mocked SSLContext and HostnameVerifier created above
        // URL.openConnecton will return mocked HttpsURLConnection
        HttpTest.processRemoteToLocal(url, "/test.out");

        // do the assertions you need
    }
}