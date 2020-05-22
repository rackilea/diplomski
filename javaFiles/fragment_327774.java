import org.my_company.my_app.domain.User

public class UserDao extends HibernateDaoSupport {

    public User getUser(String username) {
        List users = getHibernateTemplate().find("from User where username = ?", username);
        return users == null || users.size() <= 0 ? null : (User) users.get(0);
    }
}