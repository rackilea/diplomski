public class Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        XParserLinks xParserLink = new XParserLinks("something");

        XLinksMediaPK pk1 = new XLinksMediaPK(0, "image_1");
        XLinksMediaPK pk2 = new XLinksMediaPK(0, "image_2");
        XLinksMediaPK pk3 = new XLinksMediaPK(0, "image_3");

        xParserLink.add(new XLinksMedia(pk1, xParserLink));
        xParserLink.add(new XLinksMedia(pk2, xParserLink));
        xParserLink.add(new XLinksMedia(pk3, xParserLink));

        em.persist(xParserLink);

        System.out.println("Success...");

        em.getTransaction().commit();
        em.close();
    }
}