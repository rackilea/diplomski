Session session = null;
Transaction txn = null;
try {  
    SessionFactory sessionFactory = 
        new Configuration().configure().buildSessionFactory();
    session = sessionFactory.openSession();  
    txn = session.beginTransaction();
    Course course = new Course();  
    course.setDescription("Description");
    course.setName("NAME");
    course.setUrl("http://www.url.com"); 
    session.save(course); 
    txn.commit();

} catch (Exception e) { 
    System.out.println(e.getMessage());
} finally {
    if (!txn.wasCommitted()) {
        txn.rollback();
    }

    session.flush();  
    session.close();   
}