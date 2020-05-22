public class JdbcRepository {
    @Autowired
    ApplicationContext context;
    Collection<InsertListener> listeners;

    @PostConstruct
    public void init() {
        listeners = context.getBeansOfType(InsertListener.class).values();
    }
...