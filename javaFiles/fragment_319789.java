for(int i = 0; i < romanInput.length(); i++) {
   ...
   if(i < romanInput.length()){
       if(n < ((int)converter.get(romanInput.charAt(i+1)))){
           decimalValue -= n;
       }