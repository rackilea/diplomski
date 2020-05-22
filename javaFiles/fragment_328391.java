try {
    session.beginTransaction();
    try {
        session.persist(b);
        session.flush(); // only needed if flush mode is "manual"
        session.getTransaction().commit();
    } catch (Exception x) {
        session.getTransaction().rollback();
        // log the error
    }
} catch (Exception x) {
    // log the error
}