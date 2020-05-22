public class Grades 
{
    public static void main(String[] args)
    {
        JOptionPane.showMessageDialog(null, "Welcome to Jonathan's Gradebook");
        int A = 0, B = 0, C = 0, D = 0, F = 0;
        int totalGrades = 0, grade = 0, averageGrade = 0, highestGrade = 0;
        while (grade >= 0)
        {
        grade = Integer.parseInt(JOptionPane.showInputDialog("Enter one grade followed by the enter key\n when finished enter -1"));
        if (grade > 100) {
            JOptionPane.showMessageDialog(null, "No extra credit for this assignment\n please enter a value less than 100");
        } else if (grade <= 100 && grade >= 90) {
            A = A + 1;
            grade = (grade > highestGrade ? highestGrade : grade);// Determines highest grade
        } else if (grade <= 89 && grade >= 80) {
            B = B + 1;
        } else if (grade <= 79 && grade >= 70) {
            C = C + 1;
        } else if (grade <= 69 && grade >= 60) {
            D = D + 1;
        }  else if (grade <= 59 && grade >= 0) {
            F = F + 1;
        }
        totalGrades = totalGrades + 1;
        averageGrade = averageGrade + grade;
        averageGrade = (averageGrade / totalGrades);
        JOptionPane.showMessageDialog(null, "Total number of grades entered was " + totalGrades + "\n The average grade was: " + averageGrade + " percent." + "\nA's: " + A + "\nB's: " + B + "\nC's: " + C + "\nD's: " + D + "\nF's: " + F + "\nThe highest grade earned was: " + highestGrade + " percent.");
        System.exit(0);
    }

}