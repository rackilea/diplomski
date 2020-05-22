public class HotelRepositoryImpl implements MongoTemplateRepository {

    @Autowired
    private MongoTemplate mongoTemplate; // we will use this to query mongoDb

    @Override
    public List<Hotel> findByReviewsUserName(String userName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("reviews.username").is(userName));
        query.fields().include("reviews.$");
        return mongoTemplate.find(query, Hotel.class);
    }
}