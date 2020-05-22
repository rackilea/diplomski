public class StudentDashboard {

static double[] studentMathScores ={81.5,89.0,45.5,99.0,55.0,34.5,56.0,78.0,76.0,80.0};

public StudentDashboard()
{
}

public static double[] getStudentMathScores() {
    return studentMathScores;
}

public class Main {

public static void main(String[] args) {
    StudentDashboard test = new StudentDashboard();
    double[] studentMathScores = StudentDashboard.getStudentMathScores();
}