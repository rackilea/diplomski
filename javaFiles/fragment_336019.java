@Component
public class MyFirstClass{


@Value("${Application}")
private String Application;
@Value("${APP_SERVERS}")
private String servers; 


private String RED = "RED";
private String GREEN = "GREEN";
private String YELLOW = "YELLOW";   


@PostConstruct
public List<ModelSet> findall() {

//normal code that called the properties variables will be read automatically.
System.out.println(Application + "this is application from properties");
}