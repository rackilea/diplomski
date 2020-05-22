@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
public class DummyControllerITest {
  @Autowired
  private WebApplicationContext webAppContextSetup;

  @Test
  @WithMockUser(roles = "TEST")
  public void name() throws Exception {
      RestAssuredMockMvc.webAppContextSetup(webAppContextSetup);
      RestAssuredMockMvc.given()
          .when()
              .get("/")
          .then()
              .statusCode(HttpStatus.OK.value());
      RestAssuredMockMvc.reset();
  }
}