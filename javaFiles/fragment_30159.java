Statement stmt = new SimpleStatement( 
        "SELECT * FROM MyTable where myId = ?#1" +
        " AND myTypeId IN (?#2,?#3)" +
        " ALLOW FILTERING",
        #1 UUID.randomUUID(),
        #2 typeFilter );