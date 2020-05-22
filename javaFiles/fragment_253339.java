public void update(CartItems item,int qty, double price) {
    Session ses = factory.openSession();
    Transaction tr = ses.beginTransaction();
    try {
        Query q = ses.createQuery("UPDATE "
                + " CartItems "
                + " SET qty = qty + "+qty+" , sub_total = sub_total +" + qty*price
                + " WHERE model_ID=" + item.getModel().getId()
                + "  AND cart_ID=" + item.getCart().getId());
        q.executeUpdate();

        tr.commit();
    } catch (HibernateException e) {
        // handle exception
    } finally {
        // close session
    }
    incrementCartTotal(item.getCart(), NumberUtilities.parseDouble(item.getSubTotal()));
}