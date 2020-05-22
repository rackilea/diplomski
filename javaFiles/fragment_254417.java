public class NameGenerator
{
public static void main(String[] args)
{

    char[] firstname;
        firstname = args[0].toCharArray();

    char[] lastname;
    lastname = args[1].toCharArray();

    char[] mothersname;
    mothersname = args[2].toCharArray();

    char[] cityname;
    cityname = args[3].toCharArray();

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