CallableStatement cstmt = con.prepareCall( "call multi_query()" );  
boolean hasMoreResultSets = cstmt.execute();  
READING_QUERY_RESULTS:  
    while ( hasMoreResultSets ) {  
        Resultset rs = stmt.getResultSet();
        // handle your rs here
    } // while has more rs