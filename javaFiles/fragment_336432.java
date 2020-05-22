Criteria criteria = session.createCriteria(Issues.class);
criteria.setFirstResult(from);
criteria.setMaxResults(size);
criteria.setFetchMode('parent.child', FetchMode.JOIN);
criteria.add(Restrictions.eq("status", "Escalate To");
List<Issues> list= criteria.list();