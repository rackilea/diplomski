@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PropertiesConfiguration.class)
public class ConfigTest {

    @Autowired
    private Environment environment;

    @Value("${datasource.username}")
    private String username;

    @Test
    public void props() {
        System.out.println(environment.getProperty("datasource.username"));
        System.out.println(username);
    }
}