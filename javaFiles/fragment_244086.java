String number = String.valueOf(num);
char[] out = new char[number.length()];
for (int i = 0; i < number.length(); i++) {
    out[i] = digits[number.charAt(i) - '0'];
}

int leadingZeroIndex = 0;
while (out[leadingZeroIndex] == '0') {
    out[leadingZeroIndex] = ' ';
    leadingZeroIndex++;
}

System.out.println(String.valueOf(out));