public class MultipleMongoRepositoryFactoryBean<R extends MongoRepository<T, I>, T, I extends Serializable> extends MongoRepositoryFactoryBean<R, T, I> {

    protected RepositoryFactorySupport getFactoryInstance(MongoOperations operations) {
         return new MultipleMongoRepositoryFactory<T, I>(operations);
    }
}