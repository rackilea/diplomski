while (input != 0) {
    // Use JOptionPane method to accept input from user
    input = Float.parseFloat(
            JOptionPane.showInputDialog(
            null, "Please enter a number.  Enter 0 to quit: "));
    // Invoke sum method and pass input and summation to sum method
    theSum = (sum(input, theSum));
    // Invoke avg method and pass summation and counter to avg
    average = (avg(theSum, counter));
    // Increment the counter variable
    counter++;
    if (theSum > 100)
      break;
}
// Invoke display method and pass summation, average, and counter variables to it
display(theSum, average, counter);