ResultSet rs = ... // execute query
List<Student> students = ...// some list
int rowNum = 0;
while(rs.next()) {
    Student student = rowMapper.mapRow(rs, rowNum);
    students.add(student);
    rowNum++;
}

return students;