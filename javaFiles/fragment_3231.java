public class LongIntegersAritymetic {

// MAKE SURE TO CHECK THE SIGNS OF BOTH NUMBERS
// 4 SITUATIONS:
/* num1 + and num2 + =====> add
 * num1 + and num2 - =====> remove the sign from num2
 * and call substract(num1, num2_without_sign)
 * num1 - and num2 + =====> remove the sign from num1
 * and call substract(num2, num1_without_sign)
 * num1 - and num2 - =====> remove the sign from num1 and num2
 * and call add(num1_without_sing, num2_without_sign)
 * finally add the - sign to result*/


private static boolean changeResultSign = false;



public static String add(String num1, String num2) {

   String result = "";

   int n1 = 0, n2 = 0, res = 0, minLength = 0, carry = 0, maxLength = 0;

   if(num1 != null & num2 != null) {
           // num1 + and num2 + =====> add default
       // num1 - and num2 - =====> remove the sign from num1 || solved! 
       ////and call add(num1_without_sing, num2_without_sign) || solved!
       if(num1.charAt(0) == '-' & num2.charAt(0)== '-'){
           num1 = num1.substring(1);
           num2 = num2.substring(1);
           changeResultSign  = true;
       }
       // num1 - and num2 + =====> remove the sign from num1 || solved!
       //and call add(num1_without_sing, num2) || solved!
   else if(num1.charAt(0)=='-'){
       num1 = num1.substring(1);
       String a = subtarct(num2,num1);
       return a;
   }
   // num1 + and num2 - =====> remove the sign from num2 ||solved!
   //and call substract(num1, num2_without_sign) ||solved!
   else if(num2.charAt(0)=='-'){
       num2 = num2.substring(1);
       String b = subtarct(num1,num2);
       return b;
   }
  if(checkDigits(num1) & checkDigits(num2)) {
     minLength = Math.min(num1.length(), num2.length());
     maxLength = Math.max(num1.length(), num2.length());
     for(int i = 0; i < minLength; i++) {
       n1 = num1.charAt(num1.length()-1-i) - '0';
       n2 = num2.charAt(num2.length()-1-i) - '0';
       res = (n1 + n2 + carry) % 10 ;
       carry = (n1 + n2 + carry) / 10;
       // (new Integer(res)).toString();
       result = res + result ;  // CHECK THE VALIDITY OF THIS!!!
     }
     for(int i = minLength; i < maxLength; i++) {
        if(num1.length() >  num2.length()) {
           n1 = num1.charAt(num1.length()-1-i) - '0';
           res = (n1 + carry) % 10 ;
           carry = (n1 + carry) / 10;
           result =res + result ; // CHECK THE VALIDITY OF THIS!!!
        }
        else {
           n2 = num2.charAt(num2.length()-1-i) - '0';
           res = (n2 + carry) % 10 ;
           carry = (n2 + carry) / 10;
           result = res+ result ; // CHECK THE VALIDITY OF THIS!!!
        }
      }
      if(carry == 1)
        result = carry +result ; // CHECK THE VALIDITY OF THIS!!!
   } // End of if for valid digit Strings
   else
      throw new IllegalArgumentException("Invalid numbers!");
   }
   else
     throw new NullPointerException("Missing number(s)!");
return result ;
}



public static boolean checkDigits(String num) {
   boolean a = true;
    if(num != null) {
      for(int i = 0; i < num.length(); i++) {
         if(num.charAt(i) < '0' | num.charAt(i) > '9')
             a = false;

      }
      return a;  }
   else
     throw new NullPointerException("Missing number(s)!");
  }



public static void main (String[] args){
    System.out.print(add("8437598745","8437598745"));
}}