READING_QUERY_RESULTS: // label  
    while ( hasMoreResultSets || stmt.getUpdateCount() != -1 ) {  
        if ( hasMoreResultSets ) {  
            Resultset rs = stmt.getResultSet();
            // handle your rs here
        } // if has rs
        else { // if ddl/dml/...
            int queryResult = stmt.getUpdateCount();  
            if ( queryResult == -1 ) { // no more queries processed  
                break READING_QUERY_RESULTS;  
            } // no more queries processed  
            // handle success, failure, generated keys, etc here
        } // if ddl/dml/...

        // check to continue in the loop  
        hasMoreResultSets = stmt.getMoreResults();  
    } // while results