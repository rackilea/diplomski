Session session = HibernateUtil.getCurrentSession(); 
session.beginTransaction(); 

String name = (String) session
    .createSQLQuery("select name from master_employee where id = ?")
    .setInteger(1, id)
    .uniqueResult();

session.getTransaction().commit();