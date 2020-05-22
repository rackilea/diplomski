double ran;
ran = Math.random();
int r = (int)(ran*100);
Scanner in = new Scanner (System.in);
int g = 0;
System.out.print("Please make a guess between 1 and 100: ");
int counter = 0;
g = in.nextInt();
counter++;
while (g!=r) {
    if (g<=0) {
        System.out.print("Game over.");
        System.exit(0);
    }
    else if (g>r) {
        System.out.print("Too high. Please guess again: ");
        g = in.nextInt();
        counter++;
    }
    else if (g<r) {
        System.out.print("Too low. Please guess again: ");
        g = in.nextInt();
        counter++;
    }
}
System.out.print("Correct!");