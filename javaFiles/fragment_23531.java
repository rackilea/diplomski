PreparedStatement ps=con1.prepareStatement(
  "insert into EMPLOYEE_LOGIN_TIME("
    + "EMPLOYEE_ID, TIME_IN, TIME_OUT, WORKING_HOUR, PUNCH_DATE, TIME_OUT_HISTORY"
   + ") values(?,?,?,?,?,?)"
);
ps.setString(    1, Employee_id );
// ps.setString(    2, formattime );
ps.setTimestamp( 2, new java.sql.Timestamp( System.currentTimeMillis() ) );
ps.setTimestamp( 3, punch_out_timespamp ); // Should this be punch_out_timestamp?
ps.setObject(    4, timeelpased );         // Should this be timeelapsed?
ps.setDate(      5, new java.sql.Date(System.currentTimeMillis()) );
// Java 8
// ps.setDate(      5, java.sql.Date.valueOf(java.time.LocalDate.now()));
ps.setString(    6, TIME_OUT_HISTORY );
ps.executeUpdate();