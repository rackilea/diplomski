try{

               con=DatabasePool.getConnection();
               // DatabasePool is the name of the Class made earlier....
               .
               .
               .
               .  // Server operations as u wanted.....
               .
               .
             }
             catch(SQL EXCEPTION HERE)
             {
                  .....
             }
             finally
             {     
               if(con!=null)
               {
                      con.close();      
               }
             }