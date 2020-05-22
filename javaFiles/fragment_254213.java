@Transactional
public List<Test> getAccountDetailsBalanceSheet(){
    Query query = sessionFactory.getCurrentSession(). 
        createSQLQuery("SELECT name, SUM( CASE WHEN actype =  DEBIT THEN amount ELSE amount * -1 END ) AS amount FROM Account GROUP BY name")
                .setResultTransformer(Transformers.aliasToBean(Test.class));
    return (List<Test>) query.list();
}