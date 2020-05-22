int total = 0;
int digitalPower = 1;
int radPower = 1;
while (val > radPower) {
    int digit = (val / digitalPower) % 10;
    int digitValue = digit * radPower;
    total += digitValue;

    digitalPower *= 10;
    radPower *= rad;
}