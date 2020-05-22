BulkByScrollResponse response =
    DeleteByQueryAction.INSTANCE.newRequestBuilder(client)
        .filter(QueryBuilders.matchQuery("gender", "male")) 
        .source("persons")                                  
        .get();                                             

long deleted = response.getDeleted();