import java.util.Scanner;
public class Test{
     public static void main(String []args){
     String firstname, middlename, lastname;
     int age;
     Scanner  scanner = new Scanner(System.in);
     System.out.println("Enter the firstname ");
     firstname= scanner.nextLine();
     System.out.println("Enter the middlename ");
     middlename= scanner.nextLine();
     System.out.println("Enter the lastname");
     lastname= scanner.nextLine();
     System.out.println("Enter the age"); 
     if(scanner.hasNextInt()) {
        age= scanner.nextInt();
     }else
        age = 0;
     System.out.println(firstname + " " + middlename + " " + lastname + " " + age); 
    }
}