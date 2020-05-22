@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Person> getPersonByCriteria(final String criteria) {
        List<Person> results = (List<Person>) getSessionFactory().getCurrentSession().createQuery(MYSQLHERE).setString("criteria", criteria).list();
        return results;
    }
}