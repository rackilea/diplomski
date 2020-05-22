public class GenericRepositoryImplementation<T> implements GenericRepositoryInterface<T> {

    protected EntityManager entityManager;
    private Class<T> type;

    public GenericRepositoryImplementation(Class<T> type) {
        // TODO Auto-generated constructor stub
        this.type = type;
    }
}