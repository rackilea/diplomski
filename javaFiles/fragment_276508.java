public boolean delete(Purchase obj) {
    try {
        if (!session.isOpen())
            session = DatabaseUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(obj);
        session.getTransaction().commit();
        session.close();
        return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}