List<Service> services = session.createQuery(
     "select service " +
     "from Service service" +
     "  left join service.servicesLists servicesLists" + 
     "  left join servicesLists.contractorMapping contractor" +
     "where contractor.alias = 'test'")
     .list();