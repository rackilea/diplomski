public List<Customer> getView( int startPage, int maxResults) {

    EntityManager entityManager = transactionManager.getEntityManagerFactory().createEntityManager();
    Session session = entityManager.unwrap(Session.class);
    String sql = "SELECT customer.firstname, customer.lastname, customer.address, account.ano, account.bank FROM customer, account WHERE customer.cid = account.cid";
            SQLQuery query = session.createSQLQuery(sql);

            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

            List<Customer> vList = query.list();
            if (entityManager.isOpen())
                entityManager.close();
                // session.close();

            return vList;


}