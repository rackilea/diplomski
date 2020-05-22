String hql = "FROM Transaction t \r\n" + 
             " LEFT OUTER JOIN FETCH t.rc r \r\n" +
             " WHERE (t.merchantID IN (:merchant_id))\r\n" +
             " AND (t.authRequestDate BETWEEN :from AND :to)\r\n" +
             " AND (r.rcLang = :rcLang or r.rcLang is null)\r\n";

Query query =  session.createQuery(hql,Transaction.class);
query.setParameter("merchant_id", tRequest.getMerchantList());
query.setParameter("rcLang", tRequest.getLang());
query.setParameter("from", dateFrom);
query.setParameter("to", dateTo);

List<Transaction> dbTransaction = query.getResultList();