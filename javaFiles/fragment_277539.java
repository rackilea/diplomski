sess.createSQLQuery("SELECT name from City where name like 'xxyy'")
        .setResultTransformer(new ResultTransformer(){
   Object transformTuple(Object[] tuple, String[] aliases){
       // assign each tuple value to your object and return
   }

})