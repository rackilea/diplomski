import java.util.Scanner;

    public class test1 {

        // variable to use in other method
        private static int anArray[] = new int[20];
        private static int userNumber[] = new int[20];

        public static void main(String[] args) {
            // TODO Auto-generated method stub

            Scanner scanner = new Scanner(System.in);

            // get number to check in array
            for (int i = 0; i < userNumber.length; i++) {
                System.out.print("Enter number to check " + (i + 1) + " :                       ");
                userNumber[i] = scanner.nextInt();
            }
            randomFill();
            searchValue();
        }

        // generate random number
        public static void randomFill() {

            for (int i = 0; i < 20; i++) {
                anArray[i] = (int) (Math.random() * (20 - 1) + 1);
            }
        }

        // compare to the array does the input number match
        public static void searchValue() {
            for (int i = 0; i < userNumber.length; i++) {
                for (int j = 0; j < anArray.length; j++) {
                    if (userNumber[i] == anArray[j]) {
                System.out.println("Usernumber " + userNumber[i] + " exists at  ArrayIndex :" + j);
                    }
                }
            }
        }
    }