//i are the possible factors for the number
for (long i = 2L; i <= x; i++) { // <- HERE, WHY 2L and NOT 1L ?
    //answer: because 1 is not the first possible prime factor, is 2
    for (long l = 1L; l <= Math.sqrt(i); l++) { //  <-  HERE, why Math.sqrt(i) ?????
        //answer: the largest factor of a number cannot be higher than its square root
        if (l % i == 0) {
            break;
        } else {
            while (x % i == 0) {
                x = x / i; // <- Why x/i ???
                //if i is a factor of x, mark it as the current biggest factor
                biggest = i;
            }
        }
    }
}