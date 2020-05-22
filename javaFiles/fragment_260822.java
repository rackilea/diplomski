public class Example {

public static void main(String[] args) {

    // for the same lengths
    int[] num1 = { 1,9,9,9 };
    int[] num2 = { 9,9,9,9};// {9,9,9}

    // 1999+9999 = 11998, its length is greater than the max
    int capacity = Math.max(num1.length, num2.length);
    int[] arraySum = new int[capacity + 1];

    int len2 = num2.length;
    int len1 = num1.length;

    if (len1 < len2) {
        int lengthDiff = len2 - len1;

        /*
         * Flag for checking if carry is needed.
         */
        boolean needCarry = false;

        for (int i = len1 - 1; i >= 0; i--) {
            /**
             * Start with the biggest index
             */
            int sumPerPosition =0;

            if (needCarry) {
                 sumPerPosition = num1[i] + num2[i + lengthDiff] +1;
                 needCarry = false;
            }else
            {
                 sumPerPosition = num1[i] + num2[i + lengthDiff];
            }

            if (sumPerPosition > 9) {
                    arraySum[i + lengthDiff + 1] = sumPerPosition % 10;
                needCarry = true;
            }else
            {
                arraySum[i + lengthDiff + 1] = sumPerPosition % 10;
            }
        }

        /**
         * Handle the remaining part in nun2 Array
         */

        for (int i = lengthDiff - 1; i >= 0; i--) {
            /*
             * Do not need to care num1 Array Here now
             */

            if(needCarry){
                arraySum[i + 1] = num2[i]+1;
            }else
            {
                arraySum[i + 1] = num1[i] ;
            }

            if (arraySum[i + 1] > 9) {
                arraySum[i + 1] = arraySum[i + 1] % 10;
                needCarry = true;
            } else {
                needCarry = false;
            }


        }

        /*
         * Handle the last number, if carry is needed. set it to 1, else set
         * it to 0
         */
        if (needCarry) {
            arraySum[0] = 1;
        } else {
            arraySum[0] = 0;
        }

    } else {
        int lengthDiff = len1 - len2;

        /*
         * Flag for checking if carry is needed.
         */
        boolean needCarry = false;

        for (int i = len2 - 1; i >= 0; i--) {
            /**
             * Start with the biggest index
             */
            int sumPerPosition = 0;


            if (needCarry) {
                 sumPerPosition = num2[i] + num1[i + lengthDiff] +1;
                 needCarry = false;
            }else
            {
                 sumPerPosition = num2[i] + num1[i + lengthDiff];
            }

            if (sumPerPosition > 9) {
                    arraySum[i + lengthDiff + 1] = sumPerPosition % 10;
                needCarry = true;
            }else
            {
                arraySum[i + lengthDiff + 1] = sumPerPosition % 10;
            }
        }

        /**
         * Handle the remaining part in nun2 Array
         */

        for (int i = lengthDiff - 1; i >= 0; i--) {
            /*
             * Do not need to care num1 Array Here now
             */

            if(needCarry){
                arraySum[i + 1] = num1[i]+1;
            }else
            {
                arraySum[i + 1] = num1[i] ;
            }

            if (arraySum[i + 1] > 9) {
                arraySum[i + 1] = arraySum[i + 1] % 10;
                needCarry = true;
            } else {
                needCarry = false;
            }

        }

        /*
         * Handle the last number, if carry is needed. set it to 1, else set
         * it to 0
         */
        if (needCarry) {
            arraySum[0] = 1;
        } else {
            arraySum[0] = 0;
        }
    }

    /*
     * Print sum 
     * 
     * if arraySum[0] ==1, print 1
     * 
     * Do not print 0 when arraySum[0] ==0
     */
    if(arraySum[0] == 1)
    {
        System.out.print(1);
    }
    for (int i = 1; i < arraySum.length; i++) {

        System.out.print(arraySum[i]);
    }
}
}