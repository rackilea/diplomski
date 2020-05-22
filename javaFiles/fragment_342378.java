@Service
public class DataRunner {

    @Autowired
    private DataServiceResolver dataServiceResolver;

    @Value("${task.file}")
    private String taskFile;

    @PostConstruct
    public void init() {
        // process the incoming taskFile and derive an enum called DataSource

        //call the resolver and resolve to the needed dataservice. whatever can be your taskFile, etc
        DataService dataService = dataServiceResolver.resolve(whatever);
        dataService.loadData("/example/file/location"); // what I wish would work
    }
}