public List<SomeEntity> getEntityByYearMonthAndDay(Calendar cal) {
    Criteria criteria = helper.createCriteria();
    Calendar leftBorder = Calendar.getInstance();
    leftBorder.setTime(cal.getTime());
    Calendar rightBorder = Calendar.getInstance();
    rightBorder.setTime(cal.getTime());
    rightBorder.add(Calendar.DATE, 1);
    Conjunction dateConjunction = Restrictions.conjunction();
    dateConjunction.add(Restrictions.eq("dateColumn", leftBorder));
    dateConjunction.add(Restrictions.lt("dateColumn", rightBorder));
    criteria.add(dateConjunction);
    return criteria.list();
}