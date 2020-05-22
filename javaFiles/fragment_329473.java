public Hits search() {
     Map<String, Serializable> attributes = new HashMap<String, Serializable>();
     attributes.put("propertyName", "propertyValue");

     SearchContext searchContext = new SearchContext();
     searchContext.setAttributes(attributes);
     Indexer indexer = IndexerRegistryUtil.getIndexer(FileEntry.class);
     return indexer.search(searchContext);
}