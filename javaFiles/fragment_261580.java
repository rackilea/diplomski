interface MyRepository extends Repository<DomainType, Long>, MyRepositoryCustom {
  // Query methods go here
}

interface MyRepositoryCustom {
  // Custom implementation method declarations go here
}

class MyRepositoryImpl implements MyRepositoryCustom {

  private final Provider<MyRepository> repository;

  @Autowired
  public MyRepositoryImpl(Provider<MyRepository> repository) {
    this.repository = repository;
  }

  // Implement custom methods here
}