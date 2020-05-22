int previousNumber = readInt("Enter > ");

int total = previousNumber;

int count = 1;

while(true) {
    int n = readInt("Enter > ");
    if (n <= previousNumber) break;

    total += n;
    count++;
    previousNumber = n;
}