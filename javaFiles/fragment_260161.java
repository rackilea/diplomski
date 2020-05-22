import java.util.*;
public class Dynamic
{
    static ArrayList<Dynamic> users = new ArrayList<Dynamic>();
    private String fname;
    private String lname;
    private int age;
    private String course;
    private int idnum;
    public Dynamic(String Fname, String Lname, int Age, String Course, int IdNum)
    {
        fname = Fname;
        lname = Lname;
        age = Age;
        course = Course;
        idnum = IdNum;
    } 
    public String getfName()
    {
        return fname;   
    }
    public String getlName()
    {
        return lname;
    } 
    public int getAge()
    {
        return age;
    }
    public String getCourse()
    {
        return course;
    }
    public int getidNum()
    {
        return idnum;
    }
    public String toString()
    {
        return fname+" "+lname+"  "+age+"    "+course+"    "+idnum;
    }
    public static void main(String [] args)
    { 
        menu();
    }//end of main
    public static void menu()
    {        
        Scanner in = new Scanner (System.in);
        System.out.println("1: Add Student\n2: View Student");
        int choose = in.nextInt();
        switch(choose) {
            case 1:
                addStudent();
                break;
            case 2:
                viewStudent();
                break;
            }   
     }
    public static void addStudent()
    {
        Scanner in = new Scanner (System.in); 
        System.out.println("Please Enter Name of Student");
        String Fname = in.nextLine();
        System.out.println("Please Enter Last Name of Student");
        String Lname= in.nextLine();
        System.out.println("Please Enter Age of Student");
        int Age= in.nextInt();
        String trash = in.nextLine();
        System.out.println("Please Enter Course of Student");
        String Course= in.nextLine();
        System.out.println("Please Enter Id Number of Student");
        int IdNum = in.nextInt();
        Dynamic student = new Dynamic(Fname, Lname, Age, Course, IdNum);
        users.add(student);
        menu();
    }//end of add users
    public static void viewStudent()
    {
        System.out.printf("%10s%7s%8s%10s\n", "Name","Age","Course","IdNumber");
        for (Dynamic stud : users)
        {
            System.out.println(stud);
        }   
    }//end of viewusers
}