int[] nums = { 1, 7, 12, 16, 3, 8 };

StringBuilder strBigNum = new StringBuilder();
for (int n : nums)
    strBigNum.append(n);

long bigNum = 0;
long factor = 1;
for (int i = strBigNum.length()-1; i >= 0; i--) {
    bigNum += Character.digit(strBigNum.charAt(i), 10) * factor;
    factor *= 10;
}