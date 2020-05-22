public class DemoMain2 {

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    test(sc, true);

}

public static void test(Scanner input, boolean temp) {

    int choice = input.nextInt();

    if (choice == 1)
        System.out.println("Continue code");
    else if (choice == 2) {
        if (temp) {
            System.out.println("calling test method again, temp value is : "+temp);
            test(input, temp);
            // you can update temp value as required

        } else {
            System.out.println("Continue code");
            }
        }

    }
 }