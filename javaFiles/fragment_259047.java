public class Assignment2 {
    public static void main(String args[]){ 
        int next = 0;
        Scanner stdin = new Scanner(System.in);

        Random random = new Random();     
        int ran2 = (random.nextInt(10));
        int ran1 = (random.nextInt(10));
        int total = ran1 + ran2;
        char exit = 'y';

        System.out.println("First cards: " + ran1 + ", " + ran2);
        System.out.println("Total: " + total);

        while(exit != 'n' && total < 21){
            System.out.println("Do you want another card? (y/n): ");
            exit = stdin.next().charAt(0);

            next = random.nextInt(10);
            System.out.println("Card: "+ next);
            total = total + next;
            System.out.println("Total: "+ total);


        }   
        if (exit.equals('n'))
            system.exit(0);

    }
}