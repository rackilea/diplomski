import java.util.Random;

Random rand = new Random();

// Obtain a number between [0 - 49].
int n = rand.nextInt(50);

// Add 1 to the result to get a number from the required range
// (i.e., [1 - 50]).
n += 1;