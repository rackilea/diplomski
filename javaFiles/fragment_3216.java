public static char[] grading(int[] testMarks) {

    char grade = '0';
    char[] grades = new char[testMarks.length];
    int value = 0;
    int n = 0;
        while (n < testMarks.length) {
            value = testMarks[n];
            if (value >= 90) {
            grade = 'A';
            }
            else if (value < 90 && value >= 75) {
            grade = 'B';
            }
            else if (value < 75 && value >= 60) {
            grade = 'C';
            }
            else if (value < 60 && value >= 50) {
            grade = 'D';
            }
            else if (value < 50 && value >= 45) {
            grade = 'E';
            }
            else {
            grade = 'F';
            }
            grades[n] = grade;
            n++;
    }
    return grades;
}