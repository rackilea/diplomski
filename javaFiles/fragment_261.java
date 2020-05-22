public class ModelMongoRepositoryImpl  implements CustomModelMongoRepository {
    private MongoOperations mongoOperations;

    public ModelMongoRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
    public void getById(Model model){
        System.out.println("test");
    }
}