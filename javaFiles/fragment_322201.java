try (PrintWriter out = new PrintWriter(new FileWriter("new.txt"))) {
    for (Student student : students)
        out.printf("%s, %s %d %c%n",
                   student.getStudentFname(),
                   student.getStudentLname(),
                   student.getTestSore(),
                   student.getGrade());
}