List<ServiceResult> services = session.createQuery(
     "select new com.mypkg.ServiceResult(service.serviceName
               ,service.symbol, service.unit
               , service.unitPrice, service.tax) " +
     "from ServicesList serviceList" +
     "  left join serviceList.contractorMapping contractor" + 
     "  left join serviceList.servicesMapping service" +
     "where contractor.alias = 'test'")
     .list();