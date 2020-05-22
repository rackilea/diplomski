if (numberEntered != tile) {
    misses++;
}
if (misses >= 3) {
    System.out.println("You lose");
    break;
}