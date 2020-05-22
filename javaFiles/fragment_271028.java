@Mock
    HttpClient mockClient;
    @Mock
    HttpResponse mockResponse;
    @Spy
    MyClass myclass = new MyClass();
    . . .
    @Test
    public void myTestCase() {
        . . .
        when(myclass.buildHttpClient()).thenReturn(mockClient);
        when(mockClient.execute(requestCaptor.capture())).thenReturn(mockResponse);
        . . .