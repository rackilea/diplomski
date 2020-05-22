public abstract class MyClass {
    private final QueryService queryService;

    public MyClass (QueryService queryService) {
        this.queryService = queryService;
    }

    protected List<Map<String, Object>> query(String sql) {
        return queryService.executeQuery(sql);
    }
}

public class MyService {
     @Autowired
     private QueryService myQueryService;

     public void execute() {
          MyClass myClass = new MyClass(myQueryService);
     }
}