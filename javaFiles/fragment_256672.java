public class GenericDaoHibernateImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

        private Class<T> type;

        @Autowired
        private SessionFactory sessionFactory;

        public SessionFactory getSessionFactory() {
            return sessionFactory;
        }

        public void setSessionFactory(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

        public GenericDaoHibernateImpl(Class<T> type) {
            this.type = type;
        }

        // Not showing implementations of getSession() and setSessionFactory()
        private Session getSession() {
            Session session = sessionFactory.getCurrentSession();
            return session;
        }

        @Transactional(readOnly = false, rollbackFor = RuntimeException.class)
        public PK create(T o) {
            return (PK) getSession().save(o);
        }

        @Transactional(readOnly = false, rollbackFor = RuntimeException.class)
        public void update(T o) {
            getSession().update(o);
        }

        @Transactional(readOnly = true)
        public T read(PK id) {
            return (T) getSession().get(type, id);
        }

        @SuppressWarnings("unchecked")
        @Transactional(readOnly = true)
        public List<T> read() {
            return (List<T>) getSession().createCriteria(type).list();
        }

        @Transactional(readOnly = false, rollbackFor = RuntimeException.class)
        public void delete(PK id) {
            T o = getSession().load(type, id);
            getSession().delete(o);
        }

        @Transactional(readOnly = false, rollbackFor = RuntimeException.class)
        public void delete(T o) {
            getSession().delete(o);
        }