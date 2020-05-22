@Component
@PropertySource("classpath:application.properties")
public class ElasticConnection {

private static final String INDEX = "index_name";
public static final String TYPE   = "type";

@Value("${elasticsearch.user}") 
private String user;

@Value("${elasticsearch.password}") 
private String password;

//setters and getters
}