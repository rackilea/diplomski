String number = "-12342342353356.799999123456789";
int startIndex = number.length()-3;
if(number.indexOf(".") >= 0) {
    startIndex = number.indexOf(".") - 3;
}
int negative = (number.charAt(0) == '-' ? 1 : 0);
for (int i = startIndex; i > 0 + negative; i -= 3) {
    number = number.substring(0, i) + "," + number.substring(i);
}
System.out.println(number);