public Mongo( ServerAddress addr , MongoOptions options )
        throws MongoException {
        _addr = addr;
        _addrs = null;
        _options = options;
        _applyMongoOptions();
        _connector = new DBTCPConnector( this , _addr );
        _connector.start();
        _cleaner = new DBCleanerThread();
        _cleaner.start();
    }