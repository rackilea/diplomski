<cacheLoaderFactory
        class="net.sf.ehcache.distribution.jms.JMSCacheLoaderFactory"
   properties="initialContextFactoryName=com.InitialContextFactory;

    userName=uname;password=passwd;
            replicationTopicConnectionFactoryBindingName=TCF;
            replicationTopicBindingName=CACHE;
    providerURL=tcp://server1:7222,tcp://server2:7222;
    getQueueConnectionFactoryBindingName=QCF;
    getQueueBindingName=CACHE_LOAD
    "
    propertySeparator=";"
    />