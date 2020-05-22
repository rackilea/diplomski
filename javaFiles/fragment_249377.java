public interface BaseServiceFactory {

    <T> BaseService<T> create(Class<T> queryClass);
}

public class BaseController<T extends BaseEntity, ID extends Serializable> implements Serializable {
    @Inject
    private BaseServiceFactory<T> serviceFactory;
// .
// .
// .
}