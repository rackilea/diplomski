@Repository
public class DepartmentDao extends BaseHibernateDao<Department,java.lang.Integer>{

    public DepartmentDao(SessionFactory sessionFactory) {
          super(sessionFactory);
     }
}