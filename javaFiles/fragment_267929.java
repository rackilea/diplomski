Criteria criteria = session.createCriteria(clazz);
if (user == null) {
    criteria.add(Restrictions.eq("email", email);
} else {
    criteria.add(Restrictions.eq("user", user);
}
int result = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();