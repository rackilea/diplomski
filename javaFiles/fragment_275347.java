public static int[] odds(int numOdds) {
    //   int[] odds = numOdds;     // needs to be int[] odds = new int[numOdds] to 
                                   //store the values.  It is the array you will 
                                   // return.
    int[] odds = new int[numOdds];

    int start = 1;            // you need to have a starting point
    for (int i=0; i<odds.length; i++) {
    //    if (odds[i] %2 != 0) { // don't need this as you are generating odd 
                                 // numbers yourself


    //    return odds;      // You're doing this too soon.  You need to store 
                               // the numbers in the array first 

          odds[i] = start;  // store the first odd number
          start += 2;       // this generates the next odd number.  Remember that
                            // every other number is even or odd depending from
                            // where you start.

    }
    return odds;         // now return the array of odd numbers.

    }
}

public static void main(String[] args) {
    int[] theOdds = odds(3);
    System.out.println(theOdds[0] + ", " + theOdds[1] + ", " + theOdds[2]);
}