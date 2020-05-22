public class PassOrFail {
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
int total;
int gradeCounter;
int grade;
double average;

int passes = 0;
int fails = 0;
int studentCounter = 0;

total = 0;
gradeCounter = 0;

System.out.println("Enter a grade");
grade = input.nextInt();

while (grade != -1) {

    total = total + grade;
    gradeCounter++;
    studentCounter++;
    if( grade >=70 ){
        passes++;
    }
    else
    {
        fails++;
    }
    System.out.println("Enter a grade");
    grade = input.nextInt();


}
if(gradeCounter != 0){
    average = (double)total/gradeCounter;
    System.out.printf("The average for the grades is %.2f\n GradeCounter is %d",average,gradeCounter);
}
System.out.printf("\nNumber of Passes is %d \n Number of Fails is %d ", passes, fails);
}
}