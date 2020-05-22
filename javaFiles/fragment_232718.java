public void executepreparedStatementInsertStudent (Connection connection){
       PreparedStatement preparedStatementInsertStudent   =connection.prepareStatement(SQL_INSERT_STUDENT);
    // create statement
    // execute query
    // close statement

}
public void executePreparedStatementDeleteStudentById (Connection connection){
PreparedStatement preparedStatementDeleteStudentById = connection.prepareStatement(SQL_DELETE_STUDENT_BY_ID);
    // create statement
    // execute query
    // close statement
}