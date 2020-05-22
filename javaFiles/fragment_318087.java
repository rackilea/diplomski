Criteria criteria = entityManager.createCriteria(Person.class);
Criteria languageCriteria = criteria.createCriteria("language");

languageCriteria.add(Restrictions.like("locale", locale));

criteria.add(Restrictions.like("name", name));
criteria.add(Restrictions.between("time", startDate, endDate));

criteria.addOrder(Order.asc("name"));