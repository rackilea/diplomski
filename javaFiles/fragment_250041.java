Die die = new TwelveSidedDie();
int rolls = 4;
for (int roll = 0; roll < rolls; roll++) {
    int result = die.roll();
    System.out.println(result);
    sum += result;
}

System.out.println("Sum: " + sum);