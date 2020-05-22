@PersistenceContext
EntityManager em;

/**
 * @return System date on DB server
 */
public Date getSystemDate() {
    Query query = em.createNativeQuery(
            "SELECT CURRENT_TIMESTAMP", DateItem.class);
    DateItem dateItem = (DateItem) query.getSingleResult();
    return dateItem.getDate();
}