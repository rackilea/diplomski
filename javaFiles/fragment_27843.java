Criteria crit = session.createCriteria(A.class);
Criteria critb = crit.createCriteria("listB");
Criteria critc = critb.createCriteria("c");
critc.addOrder(Order.asc("num"));
List<A> listA = critc.list();
// Code to iterate over listA