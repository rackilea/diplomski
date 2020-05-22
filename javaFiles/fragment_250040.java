Die[] dice = new Die[] {new TwelveSidedDie(), new TwelveSidedDie(), new TwelveSidedDie(), new TwelveSidedDie()};
int sum = 0;
for (Die die : dice) {
    int roll = die.roll();
    System.out.println(roll);
    sum += roll;
}

System.out.println("Total: " + sum);