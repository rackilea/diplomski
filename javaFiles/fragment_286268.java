try {

    ...

}finally{

    if(connection != null){
         try{
             connection.close();      // <---- here's the problem
         }catch (Exception e){
             /* ignored */
         }
     }
 }