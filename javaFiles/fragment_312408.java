@Configuration
@EnableMapRepositories
class Application {

  @Autowired PersonRepository repository;

  @PostConstruct
  public void init() {
    repository.save(new Person(…));
  }
}