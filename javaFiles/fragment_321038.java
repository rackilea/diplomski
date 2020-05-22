@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class RegisterControllerTest
{
 @Autowired
 private WebApplicationContext  wac;
 private MockMvc mockMvc;

     @Autowired
     @InjectMocks
     private RegisterController registerController;

     @Autowired
     private LocalValidatorFactoryBeanMock  validator;

  @Before
  public void setup ( )
  {
     this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
     // if you want to inject mocks into your controller
             MockitoAnnotations.initMocks(this);
  }

    @Test
    public void testPostValidationError ( ) throws Exception
    {
        validator.fakeErrors();
        MockHttpServletRequestBuilder post = post("/info/register");
        post.param("name", "Bob");
        ResultActions result = getMockMvc().perform(post);
            // no redirect as we have errors
        result.andExpect(view().name("info/register"));
    }

    @Configuration
    @Import(DispatcherServletConfig.class)
    static class Config extends WebMvcConfigurerAdapter
    {
        @Override
        public Validator getValidator ( )
        {
            return new LocalValidatorFactoryBeanMock();
        }

        @Bean
        RegisterController registerController ( )
        {
            return new RegisterController();
        }
    }
}