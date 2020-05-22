Criteria criteria = getSession().createCriteria(getPersistentClass())
  .add(Restrictions.eq("employerId",employerId))
  .setFetchMode("card", FetchMode.JOIN)
  .createCriteria("card")
  .addOrder(Order.desc("cardId"))
  .createCriteria("salary", "sl")  // <- alias for salary
  .add(Restrictions.eq("sl.salaryType",SalaryIdentifierType.CONTRACTOR))
  .add(Restrictions.eq("sl.active","YES"));

if(startDate!=null) {
  criteria.add(Restrictions.ge("sl.startDate",startDate));
}