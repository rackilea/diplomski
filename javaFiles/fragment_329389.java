AuthCredentials credentials = AuthCredentials.createFor(account, key);
DatastoreOptions options = DatastoreOptions.builder()
        .authCredentials(credentials)
        .projectId(projectId)
        .namespace(NAMESPACE)
        .build();
Datastore datastore = options.service();