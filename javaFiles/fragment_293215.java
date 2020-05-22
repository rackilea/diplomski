CriteriaBuilder builder = em.getCriteriaBuilder();
CriteriaQuery<Dataset> criteria = builder.createQuery(Dataset.class);

Root<Dataset> root = criteria.from(Dataset.class);
criteria.select(root);

// build the subquery
SubQuery<Event> subQuery = criteria.subQuery(Event.class);
Root<Event> eventRoot = subQuery.from(Event.class);
subQuery.select(eventRoot);

ParameterExpression<String> typeParameter = builder.parameter(String.class);
Predicate typePredicate = builder.equal(eventRoot.get(Event_.type), typeParameter));

// i have not tried this before but I assume this will correlate the subquery with the parent root entity
Predicate correlatePredicate = builder.equal(eventRoot.get(Event_.dataSet), root);
subQuery.where(builder.and(typePredicate, correlatePredicate);

criteria.where(builder.exists(subQuery)));

List<DataSet> dataSets = em.createQuery(criteria).getResultList();