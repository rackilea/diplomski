@Autowired
@Qualifier("one")
private ModelMongoRepository mongoRepositoryOne;

@Autowired
@Qualifier("two")
private ModelMongoRepository mongoRepositoryTwo;