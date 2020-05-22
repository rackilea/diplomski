import static org.mockito.Mockito.when;

public class TestClass{

   @Mock
   private HttpServletRequest httpServletRequestMock;

   @Mock
   private HttpSession httpsSessionMock;

   @Mock
   private ServletContext servletContextMock;

   @Before
   public void init(){
      MockitoAnnotations.initMocks(this);
   }

   @Test
   public void test(){
       // Arrange
       when(httpServletRequestMock.getSession()).thenReturn(httpSessionMock);
       when(httpSessionMock.getServletContext()).thenReturn(servletContextMock);

       InputStream inputStream = // instantiate;

       when(servletContextMock.getResourceAsStream()).thenReturn(inputStream);

       // Act - invoke method under test with mocked HttpServletRequest

   }
}