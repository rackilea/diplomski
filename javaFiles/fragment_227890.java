@Component
public class MyBean {

    @Value("${some.prop}")
    private String prop;

    public MyBean() {

    }

    @PostConstruct
    public void init() {
        System.out.println("================== " + prop + "================== ");
    }
}