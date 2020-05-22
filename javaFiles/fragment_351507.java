public static void main(String[] args) {
        // Redefine the separators as single , separators is difficult to process
        //You would need to define possible operators like this (#OR# , #AND# ) ,surrounded by special characters to identify.
        String query ="IDUSER_>_2#OR#USERNAME_=_'KURT'";
        String tableName="TESTTABLE";
        String operator=null;
        //you can choose operator conditionally
        if(query.contains("#OR#")) operator="#OR#";
//      if(query.contains("#AND#")) operator="#AND#";
        //Used split instead of Tokenizer.
        String cols[]= query.split(operator);
        String myQuery = "SELECT ";
        String select="";
        for(String col:cols){
            if(!select.isEmpty()){
                select+=" , ";
            }
            // Only the first element is retrieved (for select)
            select+=col.split("_")[0];
        }
        myQuery+=select+" FROM "+tableName+ " WHERE ";
        // Removes all special charecters (like,  # and _ with white space)
        String subQuery = query.replaceAll("#", " ");
        subQuery=subQuery.replaceAll("_", "");
        myQuery+=subQuery;
        System.out.println("QUERY RESOLVED: " + myQuery);

    }