long x = ...
if (x == 0) {
    return 0;
}
int counter = 0;
while (x % 10 == 0) {
    counter++;
    x /= 10;
}