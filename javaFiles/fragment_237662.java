/**
 * @param args the command line arguments
 */
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);

    String regex = "[a-zA-Z ]+$";
    String regex1 = "\\d[0-9]|[1-9]";
    String regex2 = "^[a-zA-Z0-9 ]+$";
    String petName;

    StringBuilder output = new StringBuilder();

    do
    {
        System.out.print("\nHow Many Pet do you have? Give from 1-3:");
        petName = input.nextLine();

        if (petName.isEmpty())
        {
            System.out.println("Number field should not be Empty.");
        }
        else if (!petName.matches(regex1))
        {
            System.out.println("Please Enter A Valid Number!");
        }

    } while (!petName.matches(regex1));

    String[] pets = new String[Integer.parseInt(petName)];

    System.out.print("\nList Down All Your Pet Names:\n");

    for (int i = 0; i < pets.length; i++)
    {
        do
        {
            System.out.print("\nPET" + (i + 1) + ":");
            pets[i] = input.nextLine();

            if (pets[i].isEmpty())
            {
                System.out.print("String field should not be Empty.");
            }
            else if (!pets[i].matches(regex))
            {
                System.out.print("Please input a valid String.");
            }
        } while (!pets[i].matches(regex));
    }

    output.append("\nThese Are The List Of The Pets You Have:");

    for (int i = 0; i < pets.length; i++)
    {
        output.append("\nPET:").append(i + 1).append(" ").append(pets[i]);
    }

    System.out.println(output);
}