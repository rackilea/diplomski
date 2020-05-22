public BigInteger insert(String sql, Object valueObject) throws Exception
{
    Session session = Entitlement.getSessionFactory().openSession();
    Transaction txn = session.beginTransaction();

    session.createSQLQuery(sql)
           .setProperties(valueObject)
           .executeUpdate();

    BigInteger result = session.createSQLQuery("SELECT LAST_INSERT_ID()")
                               .uniqueResult();

    txn.commit();
    session.close();

    return result;
}