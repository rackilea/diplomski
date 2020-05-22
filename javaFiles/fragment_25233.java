int numStudents = Integer.parseInt(JOptionPane.showInputDialog(null,
        "Enter number of students: "));

List<Student> studentList = new ArrayList<Student>();

// loops depending on number of students in the class
for (int i = 0; i < numStudents; i++) {

    Student student = new Student();

    student.setName(JOptionPane.showInputDialog(null, "Enter Student Name: "));

    JOptionPane.showMessageDialog(null, "Enter Grades for " + student.getName(),
            " ", JOptionPane.PLAIN_MESSAGE);

    student.setExamOneGrade(Float.parseFloat(JOptionPane.showInputDialog(null, "Enter Exam 1 Grade: ")));
    student.setExamTwoGrade(Float.parseFloat(JOptionPane.showInputDialog(null, "Enter Exam 2 Grade: ")));

    // and so on ..

    // now add the student to the ArrayList
    studentList.add(student);

    JOptionPane.showMessageDialog(null, "Final Grade: " + student.getFinalGrade(),
            " " + student.getName(), JOptionPane.PLAIN_MESSAGE);
}