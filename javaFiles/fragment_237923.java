Query query = em.createQuery("select CM.salesAreaId, SM.salesAreaDesc, count(CM.salesAreaId), sum(CM.openBal), " +
                    "sum(CM.netSales) from CustomerMaster CM, SalesAreaMaster SM where CM.salesAreaId=SM.salesAreaCode and CM.companyId=SM.companyId" +
                    " and CM.companyId=:companyId group by CM.salesAreaId, SM.salesAreaDesc");
query.setParameter("companyId", companyId);
List list = query.getResultList();
for(Object o : list) {
    Object[] obj = (Object[])o;

}