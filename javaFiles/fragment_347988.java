@Autowired
private WebApplicationContext webApplicationContext

@Before()
public void setup()
{
    //Init MockMvc Object
    mockMvc = MockMvcBuilders.webAppContextSetupwebApplicationContext();  
}