System.out.println(acr);
long start = System.nanoTime();
String ans = Keyboard.readString();
long stop = System.nanoTime();
double seconds = (stop - start) / 1_000_000_000.0;
if (seconds > 2.0) {
    System.out.println("Sorry, too slow.");
} else if (ans.equals(expected)) {
    System.out.println("Correct!");
} else {
    System.out.println("Wrong. Better luck next time.");
}