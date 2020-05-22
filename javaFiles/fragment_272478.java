Query query = 
        getEntityManager().createNamedQuery("Employee.findEmployees");
    List<Object[]> result = query.getResultList();
    if (result != null) {
        for (int i = 0; i < result.size(); i++) {
            Object[] emp = (Object[]) result.get(i);
            log.info("Employee =" +emp[0]);
        }