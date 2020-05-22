Query query = new Query(new Criteria("title").is(apiRoot.getTitle()));
    Update update = new Update();
    update.set("description", apiRoot.getDescription());
    update.set("versions", apiRoot.getVersions());
    update.set("maxContentLength", apiRoot.getMaxContentLength());
    mongoOperations.upsert(query, update, apiRootCollection);