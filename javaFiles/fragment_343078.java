public double convertDigits(double num, int digits) {
    int max = Math.pow(10, digits);
    While (num > max) {
        num = num / 10;
    }
    return num;
}