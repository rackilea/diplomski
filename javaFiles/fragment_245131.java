import java.util.Scanner;


    public class RomantoInteger {
        public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter an Roman numeral with an equivalent between 0 and 3999:");
        int value = input.nextInt();
        RomantoInteger rn = new RomantoInteger();
        Roman roman = rn.new Roman(""+value); //Roman is subclass of RomantoInteger and it is been called from static method so it should be call like this rn.new Roman(""+value);

        // Here you can call any function of Roman class
        }

        public class Roman {

        private final char[] romanNumerals = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
        private final int[] romanEquivalent = { 1000, 500, 100, 50, 10, 5, 1 };
        private final String romanNum = "";   
        private int decimalNum; 

        public Roman(String input) {
            romanNum = input.toUpperCase();
        }

        //public void checkRoman(){
        //  for(int x=romanNum.length()-1;x<romanNum.length(); x++){
        //      if(romanNum.charAt(x)=='M')
        //  }
        //}

        /*
         * Method to convert roman number to decimal
         */
        public int convertToDecimal() {
            int sum[];                                     //Create a integer array
            sum = new int[romanNum.length()];               //set the size of sum array to the length of romanNum

            for (int y = 0; y < romanNum.length(); y++) {
                for (int i = 0; i < romanNumerals.length; i++) {
                    if ((romanNum.charAt(y) == romanNumerals[i])       
                            && (romanNum.length() > 1)) {             //and if length of romanNum is greater than 1
                        sum[y] = romanEquivalent[i];                       //store the value of the matching romanNumeral to an indexed variable of array sum
                    }
                    if ((romanNum.charAt(y) == romanNumerals[i])           //if
                            && (romanNum.length() == 1)) {       //and if length of romanNum is just 1
                        System.out.println(romanEquivalent[i]);     //print out the value of the matching romanNumeral
                        break;                                       //terminate looping (for loop)
                    }
                }
            }
            return add(sum);                                            //call method add
        }

        public int add(int[] sum) {
            int lastIndex = sum.length - 1;
            int decimalNum = sum[lastIndex];
            int count = 0;
            for (int i = lastIndex; count < sum.length - 1; count++) {
                if ((sum[i - 1] <= sum[i])) {                 
                    decimalNum = decimalNum - sum[i - 1];
                    --i;
                } else {
                    decimalNum = decimalNum + sum[i - 1];
                    --i;
                }
            }
            return decimalNum;
        }

    }

    }