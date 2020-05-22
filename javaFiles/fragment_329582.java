import java.util.Scanner;

class People {
    String name;
    int age;
    String hairColour;
    String personality;

    void confirm() {
        System.out.println(name + " is " + age + " years old and has " + hairColour + " hair and has a " + personality + " personality");

        Scanner correct = new Scanner(System.in);

        System.out.println("Is this correct? Y/N");
        String reply = correct.nextLine();

        if ("Y".equals(reply) || "y".equals(reply)) {
            System.out.println("Profile confirmed. Thank you.");
        } else {
            System.out.println("Returning to profile creation");
        }
    }
}

public class PeopleProfile {
    public static void main(String[] args) {
        People boy = new People();
        Scanner inputDetails = new Scanner(System.in);

        System.out.println("Please enter a name: ");
        boy.name = inputDetails.nextLine();

        System.out.println("Please enter a age: ");
        boy.age = Integer.parseInt(inputDetails.nextLine());

        System.out.println("Please enter the persons hair colour: ");
        boy.hairColour = inputDetails.nextLine();

        System.out.println("Please enter the persons personality: ");
        boy.personality = inputDetails.nextLine();

        boy.confirm();
    }
}