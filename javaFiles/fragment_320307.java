@Service
public class B{

  @Autowired
  A a;

  @PostConstruct
  public moreSetup() {
     a.doSomething();
  }
}