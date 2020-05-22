package hw5;
    import java.util.Scanner;
    public class HW5 {
    public static void main(String[] args) 
    {
        boolean wantsToContinue = true;
        while(wantsToContinue)
        {
            wantsToContinue = mathProblem();
        }
    }

    public static boolean mathProblem()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number you would like to attempt: ");
        int start = input.nextInt();
        int mult;
        for (mult = 1; mult <= 10; mult++) {
            int num = start * mult;
            System.out.print(start + " x " + mult + " = ");
            int ans = input.nextInt();
            while (ans != num) {
                System.out.print("Wrong answer, try again: ");
                int ans2 = input.nextInt();
                if (ans2 == num) {
                    break;
                } 
            }

            //System.out.print("Would you like to do another problem? ");   

        }

        boolean wantsToContinue;
        //Ask if the user would like to do another problem here, set "wantsToContinue" accordingly
        return wantsToContinue;
    }
}