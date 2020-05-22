public static int recursion(int inNumber){
    if (Math.abs(inNumber) < 10) {           //base case
        return 1;
    } else {                                 //recursive case
       return recursion(inNumber / 10) + 1;
    }
 }