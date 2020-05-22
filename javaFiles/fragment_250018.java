String input = "abc";
 int length = input.length();
 for (int i = 1;i < 2^input.length();i++){
     String bitString = convert value of i into bits (eg, 1 = 001 , 2 = 010)
     //Iterate through length of bitString
     StringBuffer newString = "";
     for (int j = 1;j < bitString.length();j++){
        if(bitString.charAt(j)=='1'){
           newString.append(convertToUpperCase(input.charAt(j));
        }else{
           newString.append(input.charAt(j));
        }
     }
     print newString
 }