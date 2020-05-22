public class BaseServiceImpl<T extends BaseEntity>
    implements BaseService<T>, Serializable {
    private final Class<T> queryClass;

    public BaseServiceImpl(Class<T> queryClass){
        this.queryClass = queryClass;
    }
}