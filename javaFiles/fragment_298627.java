String s = "1001010101011010111001011101010101010101";
 long result = 0;
 for(int i = 0; i < s.length(); i++){
    result = (long) (result + (s.charAt(i)-'0' )* Math.pow(2, s.length()-i-1));
  }
    System.out.println(result);