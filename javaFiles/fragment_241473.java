import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // * Init entity manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("playground");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // * Create two entities and persist them
        // We must persist the entities first alone before we build and flush their relation
        A a = new A();
        a.setName("foo");
        em.persist(a);

        B b = new B();
        b.setName("bar");
        em.persist(b);

        // * Build relationships between the two previous entities
        AB ab = new AB();
        ab.setA(a);
        ab.setB(b);
        ab.setDate(new Date());
        a.getAbAssociations().add(ab);
        b.getAbAssociations().add(ab);

        // * Flush our changements in the database
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}