while(rs.next())
    {
        school = new School();                              
        students.add(rs.getString(1));
        teachers.add(rs.getString(1));
        school.setStudents(students);
        school.setTeachers(teachers);               
    }