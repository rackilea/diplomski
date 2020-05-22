List<?> entity2Data=//get data from either a query or criteria
List<?> entity3Data=//get data from either a query or criteria
Criteria c = // obtain criteria from session
// basically creates an OR condition chain
Disjunction orConditions = Restrctions.disjunction();
orConditions.add(Restrictions.in("obj", entity2Data));
orConditions.add(Restrictions.in("obj", entity3Data));
c.add(orConditions);