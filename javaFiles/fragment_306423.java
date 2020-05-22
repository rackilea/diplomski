public static int BtoI(String num){                                       
        int number = 0; // declare the number to store the result
        int power = 0; // declare power variable

        // loop from end to start of the binary number
        for(int i = num.length()-1; i >= 0; i--)
        {
            // check if the number encountered is 1
            /// if yes then do 2^Power and add to the result
            if(num.charAt(i) == '1')
                number += Math.pow(2, power);
            // increment the power to use in next iteration
            power++;
        }
        // return the number
        return number;
      }