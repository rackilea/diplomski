@Service
public class SomeService {

    private final Map<String, MyConfig.Project> projects;

    @Autowired
    public SomeService(MyConfig config) {
        this.projects = config.getMyConfig();

        projects.get("projectOne").getMantisID();
        projects.get("projectTwo").getPassword();
    }
}