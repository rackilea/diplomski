List<Resource> parsysIpaysysResources = new ArrayList<>();
Map<String, String> predicateMap = new HashMap<>();
predicateMap.put("path", "/content/my-site/en/cars");
predicateMap.put("1_property", "sling:resourceType");
predicateMap.put("1_property.value", "foundation/components/parsys");
predicateMap.put("2_property", "sling:resourceType");
predicateMap.put("2_property.value", "foundation/components/iparsys");
predicateMap.put("p.limit", "-1");

QueryBuilder queryBuilder = resourceResolver.adaptTo(QueryBuilder.class);
Session session = resourceResolver.adaptTo(Session.class);
com.day.cq.search.Query query = queryBuilder.createQuery(PredicateGroup.create(predicateMap), session);
SearchResult result = query.getResult();
Iterator<Resource> resources = result.getResources();
while (resources.hasNext()) {
    parsysIpaysysResources.add(resources.next());
}