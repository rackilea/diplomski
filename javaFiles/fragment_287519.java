@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SearchService service;

    @Before
    public void setUp(){
        when(service.someMethod(any()))
                .thenReturn(SomeResponse);
    }

    @Test
    public void getSearchResults() throws Exception{
        this.mockMvc.perform(post("/something/search").header("header1","1").header("header2","2")
                .content("MY VALID JSON REQUEST HERE")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(mvcResult -> {
                    //Verrify Response here
                });
    }
}