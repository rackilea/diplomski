List<Student> students = ...
Connection con = ...
String insertSql = "INSERT INTO student VALUES (?, ?, ?)";
PreparedStatement pstmt = con.prepareStatement(insertSql);
for (Student student : students) {
    pstmt.setString(1, student.getId()); //not sure if String or int or long
    pstmt.setString(2, student.getName());
    pstmt.setString(3, student.getCity());
    pstmt.addBatch();
}
pstmt.executeBatch();
//close resources...