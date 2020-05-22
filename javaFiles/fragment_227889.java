@Component
public class MyBean {

    private final String prop;

    @Autowired
    public MyBean(@Value("${some.prop}") String prop) {
        this.prop = prop;
        System.out.println("================== " + prop + "================== ");
    }
}