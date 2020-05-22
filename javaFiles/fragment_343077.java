public double convertTwoDigits(double num) {
    While (num > 100) {
        num = num / 10;
    }
    return num;
}