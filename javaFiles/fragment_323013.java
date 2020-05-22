public class Manager {
    private SomeUrl url;

    public void setUrl(SomeUrl url) { this.url = url; }

    public void method() {
        doSomethingOnUrl(this.url.getUrlString());
    }
}

@RunWith(MockitoJUnitRunner.class)
public class ManagerTest {
    @InjectMocks
    Manager manager = new Manager();

    @Mock
    SomeUrl mockUrl;   // <- This is the mock that will be injected by Mockito

    @Test
    public void testMethod(){
         // Given
         when(mockUrl.getUrlString()).thenReturn("SomeUrl");

         // When
         manager.method();

         // Then
         verify(mockUrl, times(1)).getUrlString();
    }
}