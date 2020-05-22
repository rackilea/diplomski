public void save(Doctor dr) {
    Session s = sessionFactory.getCurrentSession();
    Doctor managedDr = s.merge(dr);
    managedDr.getUser().setIs_doctor(1);
    s.saveOrUpdate("doctor", managedDr);

}