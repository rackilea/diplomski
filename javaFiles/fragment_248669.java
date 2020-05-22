public class Main { 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you need instructions for this game? Y/N: ");
        char a = input.next().charAt(0); 
        while (a != 'y') {
            if(a =='n') {
                System.exit(0);
            }
            else{
                 System.out.println("Please enter either Y/N : ");
                 a = input.next().charAt(0);
            }
        }

        if (a == 'y') {
            System.out.println("This game is called heads and tails.");
            System.out.println("You must type h (heads), or t (tails).");
            System.out.println("You will need to keep guessing correctly, each correct guess will increase your score.");
        }
    } 
}