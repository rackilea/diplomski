@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {
@Autowired
    private SessionFactory sessionFactory;

public void updateUser(User user) {


        String hql = "update user set article = null,status=true" 
                +"where article=:key1";

        sessionFactory.getCurrentSession().createSQLQuery(hql)
        .setParameter("key1", user.getArticle());
        }
    }