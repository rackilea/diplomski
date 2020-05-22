switch(operation) {
        case "insert":                 
            query +="INSERT INTO " + table + " SET ";
            for(int i=0; i<columns.size(); i++) {
                val = values.get(i);
                if(val.length()>0) { // notice the if(), when the field has no value, it wont be put into the query string.
                    col = columns.get(i);
                    query+="`"+col+"` = '"+val+"',";
                    if(i%3==0) query+="\n";
                }

            }
            query=query.substring(0, query.length()-1);
            query += ";";
        break;