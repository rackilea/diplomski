@Component
public class PropertyReader {

    @Autowired
    private Environment env;

    public String getHost() {
        return env.getProperty("spring.mysql.host");
    }
}