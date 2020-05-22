public static long binaryStringToInteger (String binaryString){
    char[] digits = binaryString.toCharArray();
    long binaryInteger = 0;
    int count = 0;
    for(int i=digits.length-1;i>=0;i--)
      {
        if(digits[i]=='1') 
             {
              binaryInteger +=(long)Math.pow(2, count);
             }
        count++;
      }
     return binaryInteger;
    }