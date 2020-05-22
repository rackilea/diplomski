int[] digits = {1, 5, 3, 6, 3};
int totalNumber = 0;
for (int i = 0; i < digits.length; i++) {
    totalNumber = (totalNumber * 10) + digits[i];
}
System.out.println(totalNumber);