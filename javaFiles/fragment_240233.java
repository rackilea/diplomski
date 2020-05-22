import java.util.Scanner;

public class test1
{
    public static void main(String[] args) 
    {
     Scanner input = new Scanner();
    System.out.printf("Enter your first name: ");
    /* This should be string as your gettting name*/
    String firstname = input.nextLine();
     /* Don't need new variable use same and that also should be string. */
    firstname = firstname.substring(0,1);
    System.out.printf("Enter your last name: ");

    String lastname = input.nextLine();
    lastname = lastname.substring(0,2);

    System.out.printf("Enter your mother's maiden name: ");
    String mothersname = input.nextLine();
    mothersname = mothersname.substring(0,1);

    System.out.printf("Enter the name of the city in which you were born: ");
    String cityname = input.nextLine();
    cityname = cityname.substring(0,2);

    String StarWarsName = ( "firstname"  + "lastname " + "mothersname " + "cityname"); 
    System.out.println("May the force be with you, " + StarWarsName );
}

  }