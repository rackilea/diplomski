DetachedCriteria subCriteria = DetachedCriteria.forClass(Authorities.class);
subCriteria.add(Property.forName("authority").ne(authorityName));
subCriteria.setProjection(Projections.property("users"));

DetachedCriteria criteria = DetachedCriteria.forClass(getPersistentClass());
criteria.add(Property.forName("username").notIn(subCriteria));
return getHibernateTemplate().findByCriteria(criteria);