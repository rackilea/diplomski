int result = 0;
int[] decimal = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

// Test string, the number 895
String test = "DCCCXCV";

for (int i = 0; i < decimal.length; i++ ) {
    while (test.indexOf(roman[i]) == 0) {
        result += decimal[i];
        test = test.substring(roman[i].length());
    }
}
System.out.println(result);