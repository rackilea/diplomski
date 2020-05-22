Query query = entityManager.createQuery("select distinct invoice from Invoice as invoice " 
            + "left join fetch invoice.productLines "                
            + "left join fetch invoice.serviceLines "
            + "left join fetch invoice.paymentOptions");
for (Object object : query.getResultList()) {
    // Code here
}