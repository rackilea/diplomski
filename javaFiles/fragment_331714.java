public class HibernateHQLMaxFunction {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Session sess = null;
    try {
      SessionFactory fact = new 
      Configuration().configure().buildSessionFactory();
      sess = fact.openSession();
      String SQL_QUERY = "select 
max(FIELD_NAME)from Insurance insurance";
        Query query = sess.createQuery(SQL_QUERY);
        List list = query.list();
        System.out.println("Max 
Invested Amount: " + list.get(0));   
      sess.close();
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
}