package smsmain; 
import java.util.Scanner; 
     public class CStudentinfo { 
        public static void createstudent() { 
          Scanner name = new Scanner(System.in); 
          System.out.println("Please enter your first name:");     
             while(!name.hasNext("[a-zA-Z]+")){ 
                 System.out.println("Please re-enter your name, use alphabets)
                  System.out.println("Please enter your first name:"); 
                   name.nextLine(); 

              } 
        String firstname=name.nextLine(); 
        System.out.println("Your firstname is " + firstname); 
       inputEmail();