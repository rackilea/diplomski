public static void main(String[] args){
// The lowest number we will check to see if it's perfect
int min = 1; 
// The highest number we will check to see if it's perfect
int max = 10000;

// A loop to go over all numbers in the range to check which of them are perfect
for (min = 1; min <= max; min++) { 
    // The sum of proper positive divisors for our number
    int sum = 0;
    // A loop to calculate the sum of positive divisors for our number, here 'e' will
    // go from 1 to 'min-1' (because a perfect number excludes the number itself)
    for (int e = 1; e < min; e++) {
        // This if is true if the number if a proper divisor of our number ('min')
        if ((min % e) == 0) {
            // The number is a proper divisor so we add it to the sum of proper divisors
            // for our number
            sum += e;
        } 
    }  
    // We finished checking all of our proper divisors for the number 'min'
    if (sum == min){           
        // If this is is true, that means that the sum of all proper divisors
        // for 'min' equals to 'min' -> 'min' is a perfect number, so we
        // print it
        System.out.println(sum);
    }          
}