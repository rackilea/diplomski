public static int rollDice() {
    Random gen = new Random();
    die1 = gen.nextInt(6)+1;
    die2 = gen.nextInt(6)+1;
    dieSum = die1 + die2;    
    return dieSum;
}