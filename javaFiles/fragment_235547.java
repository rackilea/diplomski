public void create_custom(RuleApplGroupMst RuleApplGroupMst) {
    EntityManager em = null;
    try {
        utx.begin();
        em = getEntityManager();
        em.persist(RuleApplGroupMst);
        utx.commit();
    }  catch (Exception ex) {}