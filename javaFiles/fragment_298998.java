class Student {
    int id;
    String name;
    String addr;

    Student(int id, String name, String addr) {
        this.addr = addr;
        this.id = id;
        this.name = name;
    }
}

class School {
    int id;
    String name;
    List<Student> students = new ArrayList<>();

    School(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void addStudent(Student s) {
        students.add(s);
    }
}

/*
 * helper method that gets school from map or create if not present
 */
private School getSchool(Map<Integer, School> schoolMap, int id, String name) {
    School school = schoolMap.get(id);
    if (school == null) {
        school = new School(id, name);
        schoolMap.put(id, school);
    }
    return school;
}

// RUN QUERY

String sql = 
     " select st.ID, st.NAME, st.ADDRESS. s.id, s.name" +
     " from table_students st" +
     "   inner join table_school s on st.school_id = s.id";

    final Map<Integer, School> schoolMap = new HashMap<>();

    jdbcTemplate.query(sql, new RowCallbackHandler() {

        @Override
        public void processRow(ResultSet rs) throws SQLException {

            int studentId = rs.getInt(1);
            String studentName = rs.getString(2);
            String studentAddr = rs.getString(3);
            int schoolId = rs.getInt(4);
            String schoolName = rs.getString(5);

            Student student = new Student(studentId, studentName, studentAddr);

            getSchool(schoolMap, schoolId, schoolName).addStudent(student);
        }
    });