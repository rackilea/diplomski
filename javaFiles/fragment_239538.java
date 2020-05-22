@Component
@PropertySource("classpath:application.properties")
public class ElasticConnection {

private static final String INDEX = "index_name";
public static final String TYPE   = "type";

private String user;
private String password;

@Autowired
public ElasticConnection(@Value("${elasticsearch.user}")      String user,
                        @Value("${elasticsearch.password}") String password){
    this.user = user;
    this.password = password;
}