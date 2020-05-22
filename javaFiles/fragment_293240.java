public String createUser(Session session) {
    Transaction tx = session.beginTransaction();

    session.save(this);
    tx.commit();
    session.close();

    return "accountCreated";
}