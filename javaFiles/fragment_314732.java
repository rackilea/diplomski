public class MultipleMongoRepositoryFactory<T, ID extends Serializable> extends MongoRepositoryFactory {

    private final MongoOperations mongoOperations;

    public MultipleMongoRepositoryFactory(MongoOperations mongoOperations) {
        super(mongoOperations);
    }

    @Override
    protected Object getTargetRepository(RepositoryMetadata metadata) {
        /* Add personalyzed stuff here */
        return super.getTargetRepository(metadata);
    }

}