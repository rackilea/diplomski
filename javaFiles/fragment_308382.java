public void nameSearchTest() throws ElasticSearchUnavailableException, IOException{
    String nameToSearch = "fuzzyText";
    TrainingToCreate t = new TrainingToCreate();
    t.setName(nameToSearch);
    //Create two Trainings to find sth
    String id1 = ElasticIndexer.index(t);
    String id2 = ElasticIndexer.index(t);

    // REFRESH YOUR INDICES (just after indexing)
    client().admin().indices().prepareRefresh().execute().actionGet();