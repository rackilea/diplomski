@RunWith(MockitoJUnitRunner.class)
public class MyService1Test {
    @Mock
    private ServiceProperties serviceProperties;
    @InjectMocks
    private MyService1 myService1;

    @Test
    public void getMyLanguage(){
        when(serviceProperties.getLocale()).thenReturn(new Locale("EN"));
        myService1.getMyLanguage();
        verify(myService1).getMyLanguage();
    }
}