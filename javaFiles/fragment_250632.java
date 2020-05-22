public void printGrades(PrintStream ps, char [] grades) {
    for (char grade : grades) {
       ps.println(grade);
    }
}

public char[] calculateGrade(int [] scores){

    char [] grades = new char[scores.length];

    for (int r = 0; r < scores.length; r++){
        if (scores[r] > 90)
            grades[r] = 'A';
        else if (scores[r] > 80)
            grades[r] = 'B';
        else if (scores[r] > 70)
            grades[r] = 'C';
        else if (scores[r] > 60)
            grades[r] = 'D';
        else
            grades[r] = 'F';
    }
    return grades;

}