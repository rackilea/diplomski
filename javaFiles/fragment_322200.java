try (PrintWriter out = new PrintWriter(new FileWriter("new.txt")))
{
    for (Student student : students)
    {
        out.println(student.getStudentFname() + ", " +
                    student.getStudentLname() + " " +
                    student.getTestSore() + " " +
                    student.getGrade());
    }
}