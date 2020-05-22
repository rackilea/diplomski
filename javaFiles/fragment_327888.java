public static ArrayList<Integer> getHailstoneSequence(int n) {

        ArrayList<Integer> hailstoneSequence = new ArrayList<Integer>();
            while(true)
            {
                if(n==1)break;
            if (n % 2 == 0) { //if the remainder of n/2 is 0, then the number is even
                 hailstoneSequence.add(n);
                n = n / 2;
            }

            else {
                 hailstoneSequence.add(n);
                n = (n * 3) + 1;
            }
            }
            return hailstoneSequence;


    }

public static void main(String[] args) {
        Scanner hailstone = new Scanner(System.in);//ask user for initial number input
        System.out.println("To begin, please enter a positive integer that is not 1:");

        int n = hailstone.nextInt();

        ArrayList<Integer> list = AS.getHailstoneSequence(n);
        int i=0;
// loop through all the numbers
        for (int sequence : list) {
            try
            {

                    if(sequence==1)break;
                    if(sequence%2==0)
                    {
                        System.out.println(sequence + " is even, so I take half: " + (sequence/2));
                    }
                    else
                        System.out.println(sequence+ " is odd, so I make 3n+1: " + ((3*sequence)+1));
                    i++;

            }


            catch (Exception error) {
                while (n <= 1) {

                    System.out
                            .println("You did not enter a valid positive, greater than 1 integer. Please try again: ");
                    System.out.println();

                    n = hailstone.nextInt();

                }
}