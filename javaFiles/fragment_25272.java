public static int getNumbers(int a, int b){
    //Return if invalid input
    if(b < a){
        return -1;
    }

    int counter = 0;

    //Iterate over all numbers from the range
    for(int i = a; i <= b; ++i){
        boolean validNumber = true;

        //List of digits - we will put how many we have in here
        int[] digits = new int[10];

        //Split the number into digits
        int number = i;
        while(number > 0){
             //Get current digit
             int currentDigit = number % 10;
             //Increment the number of these digits found
             ++digits[currentDigit];
             //If number greater than 4, set flag and break loop
             if(digits[currentDigit] > 2){
                 validNumber = false;
                 break;
             }
             //Divide by 10 to get the next digit
             number = number / 10;
        }
        //Ig the number is valid, increase counter
        if(validNumber == true){
            ++counter;
        }
    }

    return counter;
}