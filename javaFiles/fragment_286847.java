double pi = 0, denominator = 1, prevPi = 1;
while (pi != prevPi) {
    prevPi = pi;
    pi += (1 / denominator) - (1 / (denominator + 2));
    denominator += 4;
}
return pi * 4;