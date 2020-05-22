public void savePerson(PersonBean personBean) {
    Session currentSession;

    try {
        currentSession = sessionFactory.getCurrentSession(); 

    } catch (HibernateException e) {
        currentSession = sessionFactory.openSession();
        System.out.println("Opened Session");
    }

    currentSession.beginTransaction(); 
    currentSession.merge(personBean);
    currentSession.getTransaction().commit()
    System.out.println("Data Saved");
}