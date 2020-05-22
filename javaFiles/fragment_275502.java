public class StudentInfo{

 public static void main(String[] args){

    int creditHours = 0;
    boolean ok = false;
    System.out.println("Please enter the number of credit hours that you currently have (do not count credit hours from classes that you are currently attending this semester)");

    while (!ok)
    {
        try
         {
           Scanner scnr = new Scanner(System.in);
           creditHours = scnr.nextInt();
           ok = true;
         }
        catch(InputMismatchException e){
           System.out.println("CLASSIFICATION ERROR: NUMBER NOT RECOGNIZED. ENTER AN INTEGER FOR CREDIT HOURS");
        }
    }


    String studentClass = checkStudent (creditHours);
    System.out.println("Official Student Classification: " + studentClass);
    }