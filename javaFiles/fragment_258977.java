@Category(AnInterface.class)
public class MyControllerTest {

   @Mock
   View mockView;

   @Mock
   [OurWebBindingInitializer] webBindingInitializer = new OurWebBindingInitializer();

   MockMvc mockMvc;

   MyStub myStub = new MyStub();


   @Before
   public void setUp()
        throws Exception {
      MockitoAnnotations.initMocks(this);
      mockMvc = standaloneSetup(new MyController(myStub))
          .setConversionService(TestConversionServiceBuilder.create())
            .setSingleView(mockView)
            .build();
   }

   ...

}