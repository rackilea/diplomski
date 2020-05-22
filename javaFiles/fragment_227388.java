public class UserDaoImpl<T extends User> extends BaseDaoImpl<T> implements UserDao<T>,BaseDao<T> {

    protected Class<T> entityClass;

    public UserDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }   
    public T getUserByUsername(String username) {
        return findSingle("from " + getEntityName() + " entity where entity.username = ?",username);
    }

    protected String getEntityName() {
        return entityClass.getSimpleName();
    }
}