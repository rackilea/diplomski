public List<Customer> searchBar(String entityProperty, String value) {

    String nativeQuery = String.format("SELECT * FROM devices WHERE customer_id IN (SELECT customers.id FROM customers WHERE %s = ?)",entityProperty);
    Query query = session.createNativeQuery(nativeQuery);
    query.setParameter(1, value);
    return query.getResultList();
}