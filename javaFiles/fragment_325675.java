@Autowired
  private SqlMapClient sqlMapClient;

  @PostConstruct
  public void init() {
      setSqlMapClient(sqlMapClient);
  }