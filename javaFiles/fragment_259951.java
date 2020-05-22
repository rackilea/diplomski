@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class, RestTemplateAutoConfiguration.class})
public class SandboxApplicationTests {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void contextLoads() {
    }

}