Session session = sessionFactory.getCurrentSession();
String selectQuery = "FROM Account as account WHERE account.username = :usernameParam";
Query query = session.createQuery(selectQuery);
query.setParameter("usernameParam", username);
@SuppressWarnings("unchecked")
List<Account> results = query.list();

if(results.isEmpty()){
    return null;
} else {
    return result;
}