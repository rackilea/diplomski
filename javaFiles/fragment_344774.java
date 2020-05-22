StudentInfo student = new StudentInfo();
    student.setRollNo(1);
    student.setName("Jo");
    student.setBirthdate(new Date());

    StudentInfo student2 = new StudentInfo();
    student.setRollNo(2);  # this isn't student2
    student.setName("JC"); # this isn't student2
    student.setBirthdate(new Date()); # this isn't student2