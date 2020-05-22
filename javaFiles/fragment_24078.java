@Repository
public class PersonRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public long countAllPersons() {
        return mongoTemplate.count(null, Person.class);
    }
}