public List<Group> findGroups() {
    final String selectStatement = "SELECT stud.id, stud.name, gr.id, gr.name FROM student stud INNER JOIN group gr ON gr.id=stud.group_id ORDER BY stud.id"; // or your query
    try {

        return jdbcTemplate.query(selectStatement, new GroupExtractor() );

    } catch (EmptyResultDataAccessException e) {
        LOGGER.error("Get all groups - empty set", e);
        return Collections.emptyList();
    }
}


public class GroupExtractor implements ResultSetExtractor<List<Group>> {
@Override
public List<Group> extractData(ResultSet resultSet) {
    Map<Group, List<Student>> studentsGroup= new HashMap<>();
    List<Group> groups = new ArrayList<>();
    try {
        while (resultSet.next()) {
          int studentId = resultSet.getInt("stud.id");
            String studentName = resultSet.getString("stud.name");
            int groupId = resultSet.getInt("gr.id");
            String groupName = resultSet.getString("gr.name");

            Group group = createGroup(groupId, groupName);
            Student student = createStudent(studentId, studentName);

            studentsGroup.putIfAbsent(group, new ArrayList<>());
            studentsGroup.get(group).add(student);

        }

        studentsGroup.forEach((group,students) ->{
            group.setStudents(students);
            groups.add(group);
        }

        return groups;

    } catch (SQLException e) {
        LOGGER.info("An error occured during extracting data", e);
    }
    return actions;
 }

private Student createStudent(String studentId, String studentName)
{
  Student student=new Student();
  student.setId(studentId);
  student.setName(studentName);
  return student;
}

//idem for createGroup
}