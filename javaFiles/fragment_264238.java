public class freeThrow {

private static int count;

    public static int simulate(int input){
        int i;
        int j;


        for (j = 1; j < 6; j++){
            System.out.println("Game " + j + ":");
            for(i = 0;i < 10; i++){
                int shot = (int)(Math.random()*101)-1;
                if (shot > input){
                    System.out.print("OUT ");//shot missed
                } else {
                    System.out.print("IN ");//shot made
                    count++;
                }
            }

            //prints the number of free throws made per game out of 10
            System.out.println("\nFree throws made: " + count + " out of 10.");
        }
        return j;
    }

    public static int average(int count) {
        int average = count/5;
        System.out.println("\nAverage is " +  average*10 + "%");
        return average;
    }

    public static int totalShots(int count) {
        int total = count;

        System.out.println("total shots made " + total);

        return total;
    }

    public static void main (String[] args){
        //asks for user input to detemine player free throw percentage
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Player's Free Throw Percentage: ");
        int input = scan.nextInt();

        simulate(input);
        average(count);
        totalShots(count);

    }
}