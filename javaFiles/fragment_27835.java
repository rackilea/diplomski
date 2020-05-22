@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = MainApplication.class)
public class AServiceTest{
    @Autowired
   private WebApplicationContext wac;
    @Autowired
   private Aservice aservice;

  @Before
  public void setupMockMvc() {
    MockitoAnnotations.initMocks(this);

    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }
  public void sampleMethodTest(){
    Assert.assertEquals(1,aservice.sampleMethod());
   }