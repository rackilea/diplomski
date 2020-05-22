@RunWith(SpringRunner.class)
@WebMvcTest(value = YourController.class, secure = false)
public class YourControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService rulesService;

    Rule mockRule = new Rule();


    @Test
    public void testLoadOneRule() throws Exception {

        Mockito.when(
                rulesService.loadOneRule(Mockito.anyString(),
                        Mockito.anyString())).thenReturn(mockCourse);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/{ruleId}","rule1")

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{id:rule1,name:'RuleName'}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

}