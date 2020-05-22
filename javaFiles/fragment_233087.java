mDBStudents = new DBhelper2(this);

    //Delete all students for testing purposes only
    mDBStudents.getWritableDatabase().delete(DBhelper2.TABLE_NAME,null,null);

    // Load some data and test methods
    mDBStudents.addStudent(new Student(1,"Fred"));
    mDBStudents.addStudent(new Student(2,"Mary"));
    Log.d("STUDENTS",mDBStudents.loadStudents());
    Student a_student_found = mDBStudents.findStudent(1,"Fred");
    Log.d("STUDENTFOUND", a_student_found.getStudentName());
    mDBStudents.updateStudent(1,"Bert");
    a_student_found = mDBStudents.findStudent(1,"Bert");
    Log.d("STUDENtFOUND",a_student_found.getStudentName());
    mDBStudents.deleteStudent(2,"Mary");
    Log.d("STUDENTS",mDBStudents.loadStudents());

    //Test alternative suggested methods
    mDBStudents.addNewStudent("Harold");
    mDBStudents.addNewStudent("Susan");
    ArrayList<Student> all_students = mDBStudents.getAllStudents();
    boolean after_first_row = false;
    StringBuilder sb = new StringBuilder("Students are :-");
    for (Student s: mDBStudents.getAllStudents()) {
        sb.append("\n\t")
                .append("Student ID is ")
                .append(String.valueOf(s.getStudentID()))
                .append(" Student name is ")
                .append(s.getStudentName());
    }
    Log.d("STUDENTS",sb.toString());
    Student another = mDBStudents.findStudent(3);
    Log.d("STUDENT 3","Student with an ID of 3 is " + another.getStudentName());