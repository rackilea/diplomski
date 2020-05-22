boolean isGood = true;
for (int i = 1; i <= 10; i++) {
    if (x % i != 0) {
        isGood = false;
        break;
    }
}
if (isGood) {
    System.out.println(x);
}