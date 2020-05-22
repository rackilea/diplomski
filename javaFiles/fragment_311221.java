import java.util.Scanner;
public class Substr {

public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.println("Please enter First Name, Middle Name and Last Name");
       String fullName = input.nextLine().toUpperCase(); // convert input to UPPERCASE
       while(fullName.charAt(fullName.length()-1)==' '){ // remove all spaces at the end of the input because it may cause problem
            fullName = fullName.substring(0, fullName.length()-1);
       }
       while(fullName.charAt(0)==' '){ // remove all spaces at the beginning of the input because it may cause problem
           fullName = fullName.substring(1, fullName.length());
       }

       String firstName = "", middleName ="", lastName ="";

       firstName = fullName.substring(0, fullName.indexOf(' ')); // the first name is from the beginning to the first occurrence of space 

       int noOfSpaces=0;
       for(int i=firstName.length(); i<fullName.length(); i++){// count the number of spaces after the first name in case user by mistake
                                                                                    // entered more than one space
            if (fullName.charAt(i)==' '){
                noOfSpaces++;
            }
            else{
                break;
            }
       }
       middleName = fullName.substring(firstName.length()+noOfSpaces, fullName.lastIndexOf(' ')); // the second name (remember we removed the spaces at the end)

       lastName = fullName.substring(fullName.lastIndexOf(' ')+1,fullName.length()); // the last name

        String customizedName = firstName + "." + middleName.charAt(0) + "." + lastName.charAt(0);
        System.out.println(customizedName); 
}