@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserTest {

   @Autowire
   private MockMvc mockMvc;
   final String CREATE_USER_URL = "/v1/user/" + "10";

   private final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
    MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

  @Test
  public void testCreateUser() throws Exception { 

    mockMvc.perform(post(CREATE_USER_URL)  
 // doesn't work either if I put "/v1/user/10" or post("/v1/user/{id}", 10) here
        .content(TestUtils.toJson(request, false))
        .contentType(contentType))
        .andDo(print())
        .andExpect(status().isCreated())
        .andReturn();  
   }
}