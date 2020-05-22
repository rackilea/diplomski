// Pay attention to a few things here. It checks if it is divisible by 4
// since every leap year must be divisible by 4. If it is,
// it checks if it is divisible by 100. If it is, it must also
// be divisible by 400, or it is not a leap year. So, if it is divisible
// by 100 and NOT divisible by 400, it is not a leap year. If it isn't 
// divisible by 100, control flows to the else statement, and since we
// already tested number % 4 we know it is a leap year.
// Pay special attention to where I located my { and }, this is the 
// standard way to do it in java, it makes your code readable by others.

if(number % 4 == 0) {
    if((number % 100 == 0) && !(number % 400 == 0)) { // NOTE THE ! OPERATOR HERE
        System.out.println("The year is NOT a leap year.");
    } else {
        System.our.println("The year is a leap year.");
    }
} else {
    System.out.println("The year is NOT a leap year");
}