@Resource public UserTransaction utx;
@Resource public EntityManagerFactory factory;

public String updateAddress(@PathVariable("pincode") String pinCode) {
    EntityManager em = factory.createEntityManager();
    try {
        Query query = em.createQuery("UPDATE Addresses SET pincode = :pincode WHERE addressid = :addressid");
        int updateCount = query.setParameter("pincode", pinCode).setParameter("addressid", "714D9F99-E19E-4595-9C5A-3560C42B1389").executeUpdate();
        utx.commit();
        if (updateCount > 0) {
            System.out.println("Number of records updated = " + updateCount);
        }
    catch (RuntimeException e) {
        if (utx != null) utx.rollback();
        LogService.error(this.getClass().getName(), ex);
            return "Failed to update";
    }
    finally {
        em.close();
    }
     return "Record Updated";
 }