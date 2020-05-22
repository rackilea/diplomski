import java.util.Scanner;
public class Driver 
{
  Student stud = new Student();
Course cour2 = new Course();


public static void main(String[] args) 
{   
    Driver driv = new Driver();

    driv.getCourseInfo();

    boolean another;
    do
    {
    another = driv.getStudentInfo();

    }while(another);
    System.out.println(driv.cour2.toString());
}

public void getCourseInfo()
{
    int sectionValid = 0;
    int instructorValid = 0;
    int roomValid = 0;
    cour2 = new Course();
    Scanner input = new Scanner(System.in);


    System.out.println("Please enter the section number (1 to 15)");
    sectionValid = cour2.setSectionNumber(input.nextInt());
    while(!(sectionValid == 1))
    {   

            System.out.println("Your input was invalid. Please enter the section number (1 to 15)");
            sectionValid = cour2.setSectionNumber(input.nextInt());
    }


    input.nextLine();

    System.out.println("Please enter the instructor for this section");
    instructorValid = cour2.setInstructor(input.nextLine());

    while (instructorValid == 0)
    {
        System.out.println("Your input cannot be blank. Please enter an instructor.");
        instructorValid = cour2.setInstructor(input.nextLine());
    }


    System.out.println("Please enter the room number.");
    roomValid = cour2.setRoom(input.nextLine());

    while (roomValid == 0)
    {
            System.out.println("The room number cannot be blank. Please enter a room number.");
            roomValid = cour2.setRoom(input.nextLine());
    }
}



public boolean getStudentInfo()
{
    boolean another = true;
    int nameValid = 0;
    int majorValid = 0;
    int gradePointAverageValid = 0;
    int hoursValid = 0;
    stud = new Student();
    Scanner input = new Scanner(System.in);


    System.out.println("Please enter a name. Press enter to quit");
    nameValid = stud.setName(input.nextLine());

    if (nameValid == 1)
    {

        another = true;
        System.out.println("Please enter a major");
        majorValid = stud.setMajor(input.nextLine());


        while (majorValid == 0)
        {
                System.out.println("The major cannot be blank. Please enter a major");
                majorValid = stud.setMajor(input.nextLine());
        }


        System.out.println("Please enter a grade point average");
        gradePointAverageValid = stud.setGradePointAverage(input.nextDouble());

        while (gradePointAverageValid == 0)
        {
            System.out.println("The grade point average has to be between 0.00 and 4.00. Please enter a grade point average");
            gradePointAverageValid = stud.setGradePointAverage(input.nextDouble());
        }


        System.out.println("Please enter the hours");
        hoursValid = stud.setHours(input.nextInt());

        while (hoursValid == 0)
        {
                System.out.println("Hours cannot be greater than 17. Please enter the hours");
                hoursValid = stud.setHours(input.nextInt());
        }


        cour2.addStudent(stud);
    }
    else
    {
        another = false;
    }
      return another;

}
}