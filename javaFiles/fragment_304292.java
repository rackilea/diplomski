public static java.sql.Date convertUtilDateSQLDate(java.util.Date utilDate){

         if( utilDate == null){
              //add log and return;
              return null;
          }
            long utilDateTime = utilDate.getTime();
            java.sql.Date sqlDate = new java.sql.Date(utilDateTime);
            return sqlDate;

        }