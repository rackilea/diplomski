@Component
public class UnitDBHelper {

    @Value("${spring.mysql.host}")
    private String host;

    // you can still not use host in constructor
    // as it will be uninitialized 

    //  rest of code
}