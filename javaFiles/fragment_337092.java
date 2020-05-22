StringBuilder b = new StringBuilder();
for (Student student : applicantArray) {
    b.append(student + "\n"); // this if you implemented toString() in Student
    b.append(student.getFamilyName() + ' ' + student.getFirstName() + "\n"); // or something like this
}
textArea.setText(b.toString());