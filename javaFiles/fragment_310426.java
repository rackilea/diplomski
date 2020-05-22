if(op == 'q') {
    num = Integer.valueOf(display).intValue();
} else {
    String[] digits = display.split("\\"+op.toString());
    num = Integer.valueOf(digits[digits.length-1]);
}