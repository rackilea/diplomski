package sessionBean;

import javax.ejb.Stateless;
import entity.userEntity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

    @Stateless
    public class userSessionBean implements userSessionBeanLocal {

        @PersistenceContext
        private EntityManager entityManager;

        @Override
        public userEntity getUser(String userName) {
            Query query = entityManager.createQuery("SELECT u FROM userEntity u WHERE u.userName = :inUserName");
            query.setParameter("inUserName", userName);
            userEntity systemUser = null;
            try {
                systemUser = (userEntity) query.getSingleResult();
            } catch (NoResultException ex) {
                ex.printStackTrace();
            }
            return systemUser;
        }


    }