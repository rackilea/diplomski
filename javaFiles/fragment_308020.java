@Configuration
@EnableBatchProcessing
@Import(MyJobSetup.class)
public class BatchConfiguration {

    private static final String FLOW_NAME = "flow1";
    private static final String PLACE_HOLDER = "empty";

    @Autowired
    private  MyJobSetup jobSetup; // <--- Inject
          // PostConstruct of MyJobSetup was executed, when it is injected

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    public List<String> files = Arrays.asList(PLACE_HOLDER);

    @Bean
    public Job readFilesJob() throws Exception {   
        List<Step> steps = jobSetUp.getFileNames() // get the list of files
             .stream() // as stream
             .map(file -> createStep(file)) // map...
             .collect(Collectors.toList()); // and create the list of steps