Criterion criterion = myCriteria.getCriterion(MyTablePeer.STARTINGDATE);

Criterion c1 = myCriteria.getNewCriterion(criterion.getTable(), 
        criterion.getColumn(), 
        "something", Criteria.LESS_THAN);
c1.and(myCriteria.getNewCriterion(criterion.getTable(), 
        criterion.getColumn(),
        someDate, Criteria.GREATER_THAN));
criterion.or(c1);
myCriteria.add(criterion);