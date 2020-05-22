@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationController.class)
@WebAppConfiguration
public class DatabaseTableServiceTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private DatabaseTableService databaseTableServiceObject;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void setDataSource() throws Exception {
        databaseTableServiceObject.setDataSource(testDataSource);
    }

    @Test
    public void validateCanConnectToDB() throws Exception {
        Assert.assertTrue(databaseTableServiceObject.canConnectToDB());
    }

}