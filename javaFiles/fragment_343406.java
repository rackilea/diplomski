// long userInput = input.nextLong()
// or
double userInput = input.nextDouble();

// expecting an integer but user put a value larger than integer
if (userInput > Integer.MAX_VALUE || userInput < Integer.MIN_VALUE) {
   // Throw your error
}  else {
   // continue your code the number is an int
   number = (int) userInput;
}