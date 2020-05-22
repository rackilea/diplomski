@Service
public class MyService {
    private final SandUtil sandUtil;

    @Autowired
    public MyService (SandUtil sandUtil) {
        this.sandUtil = sandUtil;
    }

    public void someMethod() {
        SandBoxBuilder builder = new SandBoxBuilder(sandUtil);
        ... // use it
    }
}