int total = 0;
for (int i = 0; val > Math.pow(rad, i); i++) {
    int digit = (val / (int) Math.pow(10, i)) % 10;
    int digitValue = (int) (digit * Math.pow(rad, i));
    total += digitValue;
}