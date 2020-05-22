@Scope(value = "step", proxyMode = ScopedProxyMode.INTERFACES)
@Component
public class MyItemReader implements ItemReader<Integer>, InitializingBean {

    private final List<Integer> itemsList = new ArrayList<AssignLeadsJobItem>();

    @Autowired
    private JobService jobService;

    private final String jobKey;

    @Autowired
    public MyItemReader(@Value("#{jobParameters['jobKey']}") final String jobKey) {
        this.jobKey = jobKey;
    }

    @Override
    public Integer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(itemsList.size() == 0) {
            return null;
        } else {
            return itemsList.remove(0);
        }
    }

    @Override
    public void afterPropertiesSet() {
        MyJob myJob = jobService.loadByKey(jobKey);
        for(Integer id : myJob.getIdList()) {            
            itemsList.add(id);
        }
    }
}