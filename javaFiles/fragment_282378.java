@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
public class MyControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private Service service;

    @Test
    public void getAString() {

        BDDMockito.given(service.getString()).willReturn(Mono.just("A string."));

        this.webTestClient.get().uri("/").exchange()
                .expectStatus().isOk();

    }
}