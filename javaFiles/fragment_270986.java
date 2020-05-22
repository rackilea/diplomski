public SingerEntity findById(int id) {
    Session session = null;
    SingerEntity singer = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        //start transaction
        singer = (SingerEntity) session.get(SingerEntity.class, id);
        Hibernate.initialize(singer);
        //end transaction 
    } catch (Exception e){
        e.printStackTrace();
    } finally {
        if (session != null && session.isOpen()){
            session.close();
        }
    }
    return singer;
}