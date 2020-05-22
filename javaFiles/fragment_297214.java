String sqlQuery = "insert into examschedule (class_id,examtype_id,subject_id,examdate,start_time,end_time,messagetype_id,createddate) values";
   sqlQuery = sqlQuery + "("+ classes.getId()+","+
                            exType.getId()+","+
                            subjectName.getId()+","+
                            "'"+sqlDate+"'"+","+"'"+startTime+"'"+","+"'"+endTime+"'"+","+msgType.getId()+","+"'"+sqlTimestamp+"'"+");";

 System.out.println(sqlQuery);
 query = session.createSQLQuery(sqlQuery);
 int result = query.executeUpdate();