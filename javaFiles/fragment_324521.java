Query q = getHibernateTemplate().getSession().createQuery(query );
q.setFirstResult(0); // modify this to adjust paging
q.setMaxResults(20);

// For named parameters
q.setParamter("lat",lat);
q.setParamter("lng",lng);

// For non named parameters
q.setParamter(0,lat);
q.setParamter(1,lng);
q.setParamter(2,lat);
List<VehicleDetails> vehicledata = q.list();