boolean isFirst = true;
while(true) {
    int n = readInt("Enter > ");
    if (!isFirst && n <= previousNumber) break;

    total += n;
    count++;
    previousNumber = n;
    isFirst = false;
}