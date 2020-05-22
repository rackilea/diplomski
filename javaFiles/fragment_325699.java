import java.util.*;

import javax.persistence.*;

public class TestInIds {

    public static void main(String[] args) {

        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory(
                "objectdb:$objectdb/db/test.tmp;drop");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(new MyEntity());
        em.persist(new MyEntity());
        em.getTransaction().commit();

        Query query = em.createQuery("SELECT e FROM MyEntity e WHERE e.id in :ids");
        List<Long> ids = new LinkedList<Long>();
        ids.add(1L);
        query.setParameter("ids", ids);
        List resultList = query.getResultList();
        System.out.println("result size: " + resultList.size());

        em.close();
        emf.close();
    }

    @Entity
    static class MyEntity {
        @Id @GeneratedValue
        private Long id;
    }
}