public static Exam[] readAllExams(Scanner s)
{
    Exam[] examsArray = new Exam[0];
    int count = 0;
    while (s.hasNext()) {
        Exam exam = new Exam(s.next(), s.next(), s.nextInt(), 
                s.next(), s.nextInt());
        Exam[] newArray = new Exam[count + 1];

        // copy old array to new array - this is very inefficient
        System.arraycopy(examsArray, 0, newArray, 0, examsArray.length);

        examsArray = newArray;
        examsArray[count] = exam;
        count++;
    }
    return examsArray;
}