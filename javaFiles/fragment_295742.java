IndexQuery indexQuery = new IndexQuery();
indexQuery.setId(foo.getId());
indexQuery.setObject(foo);

//creating mapping
elasticsearchTemplate.putMapping(Person.class);
//indexing document
elasticsearchTemplate.index(indexQuery);
//refresh
elasticsearchTemplate.refresh(Person.class, true);