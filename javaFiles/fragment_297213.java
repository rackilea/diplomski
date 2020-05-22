String sqlQuery = "insert into examschedule (class_id,examtype_id,subject_id,examdate,start_time,end_time,messagetype_id,createddate) values";
   String sql1 =sql1+ "("+ classes.getId()+","+
               //^^ here you are adding undefined value remove it
                            exType.getId()+","+
                            subjectName.getId()+","+
                            "'"+sqlDate+"'"+","+"'"+startTime+"'"+","+"'"+endTime+"'"+","+msgType.getId()+","+"'"+sqlTimestamp+"'"+");";

 System.out.println(sqlQuery+sql1); //complete query is in sqlQuery+sql1
 query = session.createSQLQuery(sqlQuery); //here you are passing half query use sqlQuery+sql1
 int result = query.executeUpdate();