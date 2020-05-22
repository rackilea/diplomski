public String getCustomerMappingCustomerId(String cardId) {
    getEntityManager();        
    CustomerMapping result = first(em.createQuery(
        "select c from CustomerMapping c where c.cardId = :cardId")
        .setParameter("cardId", cardId).getResultList());
    return result ==  null ? null : result.getCustomerId(); 
}

private static <T> T first(List<T> items) {
    return items == null || items.isEmpty() ? null : items.get(0);
}