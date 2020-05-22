@Override
    public void onCreate(SQLiteDatabaseHolder holder, ConnectionSource connectionSource) {
            try {
                //...
                DataPersisterManager
                 .registerDataPersisters(MyFieldClassPersister.getSingleton());
            } catch (SQLException e) {
                // log exception
            }
    }