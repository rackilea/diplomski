@Override
public void updatePageWithText(String pageName, String rawText) {
     Session session = HibernateUtils.getInstance().openSession();
     Transaction transaction=session.beginTransaction();
     String hql = "FROM WikiPage M WHERE M.name = :name";
     Query query = session.createQuery(hql);
     query.setParameter("name",pageName);

     WikiPage res = null;
     try {
         res = (WikiPage) query.list().get(0);
         res.setRawText(rawText);
         transaction.commit();
     }
     catch (IndexOutOfBoundsException e) {
         transaction.rollback();
     }
     finally {
         session.close();
     }

}