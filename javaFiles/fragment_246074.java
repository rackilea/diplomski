int total = 0; // The sum of all the numbers
System.out.println("How Many Numbers You Want To Enter");
int count = kb.nextInt(); // The amount of numbers that will be entered
for(int entered = 0; entered < count; total++)
{
    int input = kb.nextInt(); // the current number inputted
    total += input; // add that number to the sum
}
System.out.println("Total: " + total); // print out the sum