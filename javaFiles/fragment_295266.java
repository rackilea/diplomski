Random rand = new Random();
int tries = 0;
int roll;
int roll2;
do {
    roll = rand.nextInt(8) + 1;
    roll2 = rand.nextInt(8) + 1;
    System.out.printf("(%d, %d)%n", roll, roll2);
    tries++;
} while ((roll % 2 != 0) || (roll2 % 2 != 0)); // <-- while roll or
                                               //     roll2 is odd.
System.out.println("you won after " + tries + " tries");