FilterTerm toDoTerm = new FilterTerm(nameAttribute);
toDoTerm.equal(project);
FilterTerm dateFilter = new FilterTerm(dateAttribute);
Calendar c = Calendar.getInstance();
dateFilter.lessOrEqual(c.getTime());

GroupFilterTerm groupFilter = new AndFilterTerm(toDoTerm, dateFilter);
Collection<IAttributeDefinition> attributesToQuery = new LinkedList<IAttributeDefinition>();
attributesToQuery.add(nameAttribute);
attributesToQuery.add(dateAttribute);
query = new Query(storyAsset.getOid().getMomentless(), true);
query.getSelection().addAll(attributesToQuery);
query.setFilter(groupFilter);