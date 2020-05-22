QueryBuilder queryBuilder = fullTextSession
                .getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Entity.class)
                .get();
org.apache.lucene.search.Query luceneQuery = queryBuilder
                .keyword()
                .onField("field")
                .matching("value")
                .createQuery();

FullTextQuery query = fullTextSession.createFullTextQuery(luceneQuery, Entity.class);
List<Entity> result = (List<Entity>) query.list();