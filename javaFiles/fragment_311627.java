school = new School(); 
while(rs.next())
    {

        students.add(rs.getString(1));
        teachers.add(rs.getString(2)); // changed

    }  

school.setStudents(students);
school.setTeachers(teachers);