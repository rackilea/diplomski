import javax.swing.JOptionPane;

public class Grades
{
public String scoreToGrade( int score )
{
    String grade = "";
    if( score <= 100 )
    {
        if( score >= 90 ){
            grade = "A";
            return grade;
        }
    }
    else if( score <= 89 )
    {
        if( score >= 80 ) {
            grade = "B";
            return grade;
        }

    }
    else if( score <= 79 )
    {
        if( score >= 70 ) {
            grade = "C";
            return grade;
        }
    }
    else if( score <= 69 )
    {
        if( score >= 60 ) {
            grade = "D";
            return grade;
        }
    }
    else if( score <= 59 )
    {
        if( score >= 50 ) {
            grade = "E";
            return grade;
        }
    }
    else if( score <= 49 )
    {
        if( score >= 0 ) {
            grade = "F";
            return grade;
        }
    }
    else
    {
        grade = "Error: score " + score;
    }
    return grade;
}

public static void main( String[] args )
{
    String input = JOptionPane.showInputDialog( "Score: " );
    int score = Integer.parseInt( input );
    Grades t = new Grades();
    String grade = t.scoreToGrade( score );
    JOptionPane.showMessageDialog( null,
        "For " + score + " points, your grade is:  " + grade );
}
}