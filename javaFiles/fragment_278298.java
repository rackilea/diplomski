SearchParameters sp = new SearchParameters();
sp.setLanguage(SearchService.LANGUAGE_LUCENE);
sp.setQuery(query);
sp.addStore(Repository.getStoreRef());
String field = org.alfresco.repo.search.impl.lucene.QueryParser.escape("@cm:created"); 
sp.addSort(org.alfresco.repo.search.impl.lucene.QueryParser.escape(field), false);