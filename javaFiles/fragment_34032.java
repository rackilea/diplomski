public class ADDBinary {

public static void main(String[] args) {
    // TODO Auto-generated method stub
    String num1 = "1101";
    String num2 = "1010";
    String sum = "";
    int carry = 0;
    for (int i = 0; i < num1.length() && i < num2.length(); i++) {
        System.out.println("In for loop");
        char digit1, digit2;
        digit1 = num1.charAt(num1.length() - i - 1);
        digit2 = num2.charAt(num2.length() - i - 1);
        System.out.println("Digits="+digit1+digit2);
        if (digit1 == '0' && digit2 == '0' && carry == 0) {
            sum =  sum + "0";
            carry = 0;
        } else if (digit1 == '0' && digit2 == '1' && carry == 0) {
            sum = sum + "1";
            carry = 0;
        } else if (digit1 == '1' && digit2 == '0' && carry == 0) {
            sum = sum + "1";
            carry = 0;
        } else if (digit1 == '1' && digit2 == '1' && carry == 0) {
            sum = sum + "0";
            carry = 1;
        } else if (digit1 == '0' && digit2 == '0' && carry == 1) {
            sum = sum + "1";
            carry = 0;
        } else if (digit1 == '0' && digit2 == '1' && carry == 1) {
            sum = sum + "0";
            carry = 1;
        } else if (digit1 == '1' && digit2 == '0' && carry == 1) {
            sum = sum + "0";
            carry = 1;
        } else if (digit1 == '1' && digit2 == '1' && carry == 1) {
            sum = sum + "1";
            carry = 1;
        }
    }
    if(carry == 1)
        sum = sum + "1";
    System.out.println(new StringBuilder(sum).reverse().toString());

}