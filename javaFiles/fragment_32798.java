import java.util.*;

public class testScores {

    public static void main(String[] args){


        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Student[] students = new Student[n];
        for(int i = 0; i < n; i++){
            students[i] = new Student();
            System.out.print("Enter the student's name");
            students[i].setName(scan.next());
            scan.nextLine();
            System.out.print("Enter the student's score");
            students[i].setScore(scan.nextInt());
            scan.nextLine();
        }

        int total = 0;
        int smallest_name = 0;
        for(int i = 0; i < n; i++){
            total+=students[i].getScore();
            if(students[i].getName().length() < students[smallest_name].getName().length())
                smallest_name = i;
        }

        int second_smallest = 0;
        for(int i = 0; i < n; i++){
            if(students[i].getName().length() > students[smallest_name].getName().length() && students[i].getName().length() < students[second_smallest].getName().length())
                second_smallest = i;
        }

        System.out.println("The sum of the scores is: " + total);
        System.out.println("The second smallest name is: " + students[second_smallest].getName());

    }
}

class Student{

    private String name;
    private int score;

    public Student(){}

    public void setScore(int n){
        score = n;
    }

    public void setName(String n){
        name = n;
    }

    public int getScore(){
        return score;
    }

    public String getName(){
        return name;
    }

}