int sum = 0;
int count = 0;
for (int i = 0; i <= value; i++) {
    if (i % 2 != 0) {
        sum += i;
        count++;
    }
}
int avg = sum / count;