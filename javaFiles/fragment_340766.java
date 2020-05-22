private Set<String> getRandomUsers(PreparedStatement ps) {
// lots of code.    
        try {
            SimpleStatement query = new SimpleStatement(sql);
            query.setConsistencyLevel(ConsistencyLevel.QUORUM);
            // abstract the handling of the cache to it's own class.
            // this will need some work to make sure it's thread safe
            // as currently it's not.
            ResultSet res = session.execute(psCache.getStatement(sql));