import com.company.app.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Repository
public class UserDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional(propagation = Propagation.REQUIRED)
    public void createUser(User user) {
        em.persist(user);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User readUserById(UUID id) {
        CriteriaQuery<User> query = em.getCriteriaBuilder().createQuery(User.class);
        query.where (em.getCriteriaBuilder().equal(query.from(User.class).get("id"),id.toString()));
        return em.createQuery(query).getSingleResult();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Set<User> readAll() {
        CriteriaQuery<User> query = em.getCriteriaBuilder().createQuery(User.class);
        query.from(User.class);
        return new HashSet<User>(em.createQuery(query).getResultList());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public User update(User user) {
        return em.merge(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(User user) {
        em.remove(user);
    }
}