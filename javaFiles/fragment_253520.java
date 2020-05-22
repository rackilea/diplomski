public class Student implements Comparable<Student>{

public int studentID, mark;
public String fName, lName, grade;

public Student(int studentID, String fName, String lName, int mark, String grade) {
    super();
    this.studentID = studentID;
    this.fName = fName;
    this.lName = lName;
    this.mark = mark;
    this.grade = grade;
}

public int getStudentID() {
    return studentID;
}

public String getfName() {
    return fName;
}

public String getlName() {
    return lName;
}

public int getMark() {
    return mark;
}

public String getGrade() {
    return grade;
}

@Override
public int compareTo (Student s) {

    if (this.mark == s.mark) {
        return this.fName.compareTo(s.fName);
    } else {
        return (s.mark - this.mark) > 0 ? 1 : -1;
    }
}

@Override
public String toString() {
    return "Student{" + "studentID=" + studentID + ", mark=" + mark + ", fName=" + fName + ", lName=" + lName + ", grade=" + grade + '}';
}

}