import java.util.Scanner;

public class NameGenerator
{
public static void main(String[] args)
{

    Scanner input = new Scanner(System.in);

    System.out.printf("Enter your first name: ");
    char[] firstname;
        firstname = input.next().toCharArray();

    System.out.printf("Enter your last name: ");
    char[] lastname;
    lastname = input.next().toCharArray();

    System.out.printf("Enter your mother's maiden name: ");
    char[] mothersname;
    mothersname = input.next().toCharArray();

    System.out.printf("Enter the name of the city in which you were born: ");
    char[] cityname;
    cityname = input.next().toCharArray();

    String GenFirstName = "";
    String GenLastName = "";

    for(int count = 0; count <= 3; count++){
        GenFirstName += firstname[count];
        GenLastName += mothersname[count];
    }

    for(int count = 0; count <= 3; count++){
        GenFirstName += lastname[count];
        GenLastName += cityname[count];
    }

    System.out.println("May the force be with you, " + GenFirstName + " " + GenLastName );
}

}