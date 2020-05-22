@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MyTests {

    @LocalServerPort private int port;
    @Autowired private TestRestTemplate restTemplate;

    @Test
    public void healthCheck() {
        String url = "http://localhost:" + port + "/actuator/health";

    //  choose one of the following...
        ResponseEntity<JsonNode> e = restTemplate.getForEntity(url,JsonNode.class);
        Map<String,Object> b = restTemplate.getForObject(url,Map.class);
        Map b = restTemplate.getForObject(url,Map.class);
        ResponseEntity<Map> e = restTemplate.getForEntity(url,Map.class);

        System.out.println("entity: "+e);
        System.out.println("body: "+b);
    }
}