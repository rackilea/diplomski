IndexRequest indexRequest = new IndexRequest(INDEX);
    indexRequest.id(document.getId());
    indexRequest.source(document, XContentType.JSON);
    indexRequest.opType("create");

    // add this line
    indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);

    // assert: at this point the document will be searchable