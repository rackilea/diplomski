@Autowired
private MongoTemplate mongoTemplate;

Query query = new Query();
List<String> list = Arrays.asList("Trump", "Election");
query.addCriteria(Criteria.where("keywords").in(list));
List<YourModel> yourModel = mongoTemplate.find(query, YourModel.class);