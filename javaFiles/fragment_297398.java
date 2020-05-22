@RunWith(PowerMockRunner.class)
@PrepareForTest(ClientBuilder.class)
public class AbstractGenericRestActiveProxyTest {

final Client mockClient = Mockito.mock(Client.class);
final Response mockResponse = Mockito.mock(Response.class);

private final AbstractRestProxy proxy = new AbstractRestProxy();

@Before
public void start() {
    Mockito.when(this.mockResponse.getStatus()).thenReturn(200);

    final Builder mockBuilder = Mockito.mock(Builder.class);
    Mockito.when(mockBuilder.get()).thenReturn(this.mockResponse);
    Mockito.when(mockBuilder.post(Matchers.any())).thenReturn(this.mockResponse);
    Mockito.when(mockBuilder.put(Matchers.any())).thenReturn(this.mockResponse);
    Mockito.when(mockBuilder.delete()).thenReturn(this.mockResponse);

    final WebTarget mockWebTarget = Mockito.mock(WebTarget.class);
    Mockito.when(mockWebTarget.path(Matchers.anyString())).thenReturn(mockWebTarget);
    Mockito.when(mockWebTarget.request(MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON)).thenReturn(mockBuilder);

    Mockito.when(this.mockClient.target(Matchers.anyString())).thenReturn(mockWebTarget);

    PowerMockito.mockStatic(ClientBuilder.class);
    PowerMockito.when(ClientBuilder.newClient()).thenReturn(this.mockClient);
    this.proxy.base();
}

@After
public void stop() {
    this.proxy.close();
}

@Test
public void testGetByID() {
    Mockito.when(this.mockResponse.getStatus()).thenReturn(200);

    final Response result = this.proxy.getByID(1);
    Assert.assertEquals(200, result.getStatus());
}