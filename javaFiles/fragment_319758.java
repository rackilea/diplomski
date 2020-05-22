// Use disjunction() or conjunction() if you need more than 2 expressions
Disjunction aOrBOrC = Restrictions.disjunction(); // A or B or C
aOrBOrC.add(Restrictions.eq("b", "a"));
aOrBOrC.add(Restrictions.eq("b", "b"));
aOrBOrC.add(Restrictions.eq("b", "c"));

// Use Restrictions.and() / or() if you only have 2 expressions
crit.add(Restrictions.and(Restrictions.eq("a", "abc"), aOrBOrC));