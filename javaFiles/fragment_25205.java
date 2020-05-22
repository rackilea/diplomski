UpdateByQueryRequestBuilder ubqrb = UpdateByQueryAction.INSTANCE.newRequestBuilder(client);

Script script = new Script("ctx._source.List = [\"Item 1\",\"Item 2\"]");

BulkIndexByScrollResponse r = ubqrb.source("twitter")
    .script(script)
    .filter(termQuery("user", "kimchy"))
    .get();