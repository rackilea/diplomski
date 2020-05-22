import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);

        int[] tab = { 10, 4, 23, 45, 28, 34, 89, 9, 16, 55 };
        int choice = 0;

        do {
            System.out.println();
            System.out.println("*********Menu*********");
            System.out.println("1) - The biggest number : ");
            System.out.println("9) - Exit :");

            System.out.print("Enter your choice please : ");
            choice = enter.nextInt();

            switch (choice) {

            case 1:
                System.out.println("Option 1 :");
                System.out.print("The biggest number is  => " + biggest_number(tab));
                break;
            }

        } while (choice != 9);
    }

    public static int biggest_number(int[] tab) {
        int big=tab[0];
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > big) {
                big = tab[i];
            }
        }
        return big;
    }
}