@Repository
@Transactional
public abstract class AbstractBaseEntityGenericDao<T extends BaseEntity> {

    ...        

    protected SessionFactory sessionFactory;

    ...
}