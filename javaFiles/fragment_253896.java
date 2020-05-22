import java.util.Scanner;

public class StringSearch {
    public static void main(String[] args) {
        int i;
        Scanner sc = new Scanner(System.in);
        String[] names = new String[5];

        for (i = 0; i < names.length; i++) {
            System.out.print("Enter name " + (i + 1) + " > ");
            names[i] = sc.nextLine();
        }

        System.out.print("Input Name to compare > ");
        String inName = sc.nextLine();

        for (i = 0; i < names.length; i++) {
            if (inName.equals(names[i])) {
                System.out.println("Data found at [" + i + "]");
                break;
            }
        }

        // If the value stored in `inName` is found, the value of `i` will not reach up
        // to the value equal to `names.length` because of the `break` statement. If the
        // value of `i` has reached there, it means that the value stored in `inName`
        // has not been found.
        if (i == names.length) {
            System.out.println("Data not found!");
        }
    }
}