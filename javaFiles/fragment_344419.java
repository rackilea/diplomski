public void retrieveToDB(String data) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    // I don't think you need to start a transaction just to do a SELECT statement
    //session.beginTransaction();

    Query q = session.createQuery("SELECT e from Employee e where e.empName = :empname");
    q.setParameter("empname", data);
    List results = (List) q.list();

    String test = null;
    Iterator iter = results.iterator();

    while (iter.hasNext()) {
        Employee emp = (Employee) iter.next();
        test = emp.getEmpName();
    }

    sendMsg(test);
}