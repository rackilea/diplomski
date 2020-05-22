// disable ModificationWatcher
    getResourceSettings().setResourcePollFrequency(null);

    // use plain JDK Object(Input|Output)Stream
    ISerializer serializer = new GaeObjectSerializer(getApplicationKey());
    getFrameworkSettings().setSerializer(serializer);

    // save older version of pages in the HttpSession
    final IDataStoreEvictionStrategy evictionStrategy = new PageNumberEvictionStrategy(10);
    setPageManagerProvider(new GaePageManagerProvider(this, evictionStrategy));

    // disable file cleaning because it starts a new thread
    getResourceSettings().setFileCleaner(null);