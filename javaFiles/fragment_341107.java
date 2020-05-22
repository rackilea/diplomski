Scanner input = new Scanner(System.in);
int a;  // To hold User's current entry value.
int count = 0;  // To hold the number of times the same value was entered.
int prevInt = 0;  // To hold the value previously entered.
do{
    // Since we're in a loop we only need to have
    // a single prompt.
    System.out.print("Enter an integer: --> ");
    a = input.nextInt();   // Get User Input
    // Is User entry equal to what what entered
    // previously?
    if (a == prevInt) { 
        // Yes it is...
        count++;    // Increment our counter
        // if our counter reaches 3 then let's
        // break out of our do/loop.
        if (count == 3) { break; }
        // Otherwise let's continue the loop from
        // the start.
        continue; 
    }
    // Nope, not equal to the User's last entry so
    // let's make prevInt hold the Users new entry.
    prevInt = a;
    // Let's reset our counter to 1. We need to set
    // to 1 because the last User's input which is 
    // now held in prevInt is the actual first entry
    // for the new integer value.
    count = 1;
} while(count < 3);  // Keep looping if our counter is less than 3

// Display that a triple entry was made.
System.out.println("Same integer (" + a + ") entered thrice");