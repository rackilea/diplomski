public static int reverseDigit(int num){
        int reverse=0;
        while( num != 0 )
        {
            reverse = reverse * 10;
            reverse = reverse + num%10;
            num = num/10;
        }
        return reverse;
    }