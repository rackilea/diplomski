String a = "1 Economy 1 bed, type 452, lcd 4 king bed , 11 queen bed 2";
    int sum = 0;

    for(int i = 0; i < a.length(); i++) {
       char currChar = a.charAt(i);
       if(Character.isDigit(currChar)) {
        if(i -1 >= 0 && i+1 < a.length() && !Character.isDigit(a.charAt(i+1)) && !Character.isDigit(a.charAt(i-1))){
          sum += Character.getNumericValue(currChar);
        }else if(i+1 >= a.length() && !Character.isDigit(a.charAt(i-1))){
            sum += Character.getNumericValue(currChar);
        }else if(i == 0 &&  !Character.isDigit(a.charAt(i+1))){
            sum += Character.getNumericValue(currChar);
        }
       } 
    }
    System.out.println(sum);