public void save(CartItems item) {
    Session ses = factory.openSession();
    try {
        Transaction tr = ses.beginTransaction();
        ses.save(item);
        tr.commit();

        incrementCartTotal(item.getCart(), NumberUtilities.parseDouble(item.getSubTotal()));
    } catch (HibernateException e) {
       // handle exception
    } finally {
        // close session
    }
}