String testString = value[4];
if(testString.size() >= 3){  //must be at least 3 digits
    int last3rdPosition = testString.size() - 3; 

    if(testString.charAt(last3rdPosition) == '.'){

         //check if the last third char is "."
         //handle cases like 31.35 (change it to 31,35)
         testString.setChar(last3rdPosition, ',');
    } else if (testString.charAt(0) == '0' 
               && testString.charAt(1) == '.'){

         //handle cases like 0.0213 (change it to 0,0213)
         testString.setChar(1, ',')
    }else if (testString.charAt(0) == '-' 
               && testString.charAt(1) == '0'
               && testString.charAt(2) == '.'){

         //handle cases like -0.0315 (change it to -0,0315)
         testString.setChar(2, ',')
    } 

}  
// do converting as per normal using Locale.GERMANY
// Locale.GERMANY will treat "." as the thousands separator
//                       and "," as the decimal separator
NumberFormat nf = NumberFormat.getInstance(Locale.GERMANY);
Double parsedNumber = nf.parse(testString).doubleValue();