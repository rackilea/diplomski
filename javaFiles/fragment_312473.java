public static int digitCount(int number, int digit){.
    int result=0;
    if(number<0){
        return (number*-1);//this is to accomodate positive or negative numbers
    }
    if(number<10){
         if(number==digit){
              result++;
         }
    }else if(number%10==digit){
         result++;
         result+= digitCount(number/10,digit);
    }else{
        result+=digitCount(number/10,digit);
    }

    return result;

}