Criteria tbl2Criteria = getSession().createCriteria(tbl2Class.class);
tbl2Criteria.add(Restrictions.eq("id", id));
Criteria tbl1Criteria = tbl2Criteria.createCriteria("tbl1Class");//assuming thats the name of the tbl1 instance in tbl2 class
tbl1Criteria.add(Restrictions.eq("someOtherThanKeyColumn", messageType));
tb12Criteria.add(Restrictions.or(categoryRestriction, strategyRestriction));
List<tbl2Class> result = tbl2Criteria.list();