public List<PaymentTransactions> transactionsByDate(LocalDateTime start_date, LocalDateTime end_date, Merchants merchant, Terminals terminal,
    PageInfo pageInfo) throws Exception {

    //figure out number of total rows
    String count_hql = "select count(*) from " + PaymentTransactions.class.getName() + " e where e.created_at >= ? and e.created_at <= ?";
    Query count_query = entityManager.createQuery(count_hql);
    int count = countQuery.uniqueResult();

    //figure out total pages
    int total_page = (int)Math.ceil(count/(double)pageInfo.getPerPage());
    pageInfo.setTotal_Page(total_page);

    String hql = "select e from " + PaymentTransactions.class.getName() + " e where e.created_at >= ? and e.created_at <= ?";
    Query query = entityManager.createQuery(hql)
        //set starting point
        .setFirstResult((pageInfo.getCurrentPage()-1) * pageInfo.getPerPage)
        //set max rows to return
        .setMaxResults(pageInfo.getPerPage)
        .setParameter(0, start_date).setParameter(1, end_date);
    List<PaymentTransactions> paymentTransactions = (List<PaymentTransactions>) query.getResultList();
    return paymentTransactions;
}