public static void deleteStudent() throws HibernateException {
            Session newSession = factory.openSession();
            newSession.beginTransaction();
            newSession.createQuery("delete from student s where smarks < 35")
                      .executeUpdate(); //Used for updates and deletes
            newSession.getTransaction().commit();
            newSession.close();
}