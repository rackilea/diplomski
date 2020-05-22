@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GlobalFilterTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void shouldReturn500StatusWhenControllerThrowsAnException() throws Exception {

        webTestClient.get().uri("/api/data")
            .exchange()
            .expectStatus().is5xxServerError();

    }

}