@Component
@JobScope
public class ScanItemReader extends RepositoryItemReader<Scan> {

  private final ScanJpaRepository repository;

  @Autowired
  public ScanItemReader(final ScanJpaRepository repository) {
    super();
    this.repository = repository;
  }

  @PostConstruct
  protected void init() {
    final Map<String, Sort.Direction> sorts = new HashMap<>();
    sorts.put("Your sort parameter"), Direction.ASC);// This could be any field name of your Entity class
    this.setRepository(this.repository);
    this.setSort(sorts);
    this.setMethodName(""); // You should sepcify the method which  
               //spring batch should call in your repository to fetch 
               // data and the arguments it needs needs to be  
               //specified with the below method.  
               // And this method  must return Page<T>
    this.setArguments();
  }
}