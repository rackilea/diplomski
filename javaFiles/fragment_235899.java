public void updateAccessToken(int id , String accessToken) {

    try {
        Session session = new HVR().getSession();

session.getTransaction().begin();
        System.out.println("ID :--> " + id);
        String hql = "UPDATE UCred set accessToken ='" + accessToken + "'" + " WHERE id ='" + id + "'";
        Query query = session.createQuery(hql);
        query.executeUpdate();

session.getTransaction().commit();

        session.close();
    }catch(Exception exc) {
        exc.printStackTrace();
    }
}