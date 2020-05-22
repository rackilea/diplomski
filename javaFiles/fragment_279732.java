public BigInteger(String num){
        int l = number.length;
        for(int i=0;i<l;i++) {
          //Change is here
          number[i] = num.charAt(i);
        }   
        length = l;
}