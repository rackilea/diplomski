while (carryOn)
{
    Do your code here.
    Show the dialog box.
    If (userInput.equalsIgnoreCase("no"))
        carryOn = false;
        System.out.println("Goodbye"); // The loop terminates.
    else if (userInput.equalsIgnoreCase("yes"))
        carryOn = true;
        // User is returned to the start of the loop to enter another number.
}