package studentTestScores;
public class Student {

public int highScore;
public string studentName;
public int subjectNum;

public static void main(String[] args) 
{
    Student s1;
    String str;
    int i;

    s1 = new Student();

    s1.highScore = 0;
    s1.studentName = "";
    s1.subjectNum = 0;

    s1.setName("Bill");
    s1.setScore(1, 84);
    s1.setScore(2, 86);
    s1.setScore(3, 88);

    str = s1.getName();
    System.out.println(str);

    i = s1.getHighScore();
    System.out.println(i);

}

 public void compareAndSetHighScore(int i, int j) {
     if(highScore < j)
     {
        highScore = j;
        subjectNum = i;//If you need to print subject Number too.
     }
 }

 public int getHighScore() {
     return highScore;
 }

 public String getName() {
     return studentName ;
 }

 public void setName(String string) {
     studentName = string;
 }