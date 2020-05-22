JpaTransactionManager txManager = (JpaTransactionManager) context.getBean("transactionManager");
    TransactionDefinition def = new DefaultTransactionDefinition();
    TransactionStatus status = txManager.getTransaction(def);
    try {
        String jpql = "query";
        Query query = em.createQuery(jpql).setParameter("id", id);
        User singleResult = (User) query.getSingleResult();
        singleResult.setActive(false);
        this.em.merge(singleResult);
        this.em.flush();
        txManager.commit(status);
    } catch (Exception e) {
        logger.error("lockUser(Long)", e);
        throw e;
    }
}