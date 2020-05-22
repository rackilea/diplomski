String a=qw.getStringExtra("19");  // 19 is the extra name, right???
int b = 0;
try {
    b= Integer.parseInt(a);
} catch (NumberFormatException e) {
    // tell error because extra string is not an integer number
}