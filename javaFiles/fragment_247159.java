public abstract class BaseHibernateDao<E, PK extends Serializable>
    extends HibernateDaoSupport implements EntityDao<E, PK> {

     @Autowired
     public BaseHibernateDao(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
     }
 }