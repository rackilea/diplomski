int[] arr = {1, 23, 4, 55};
int sum = 0;
for (int i : arr) {
    if (Math.abs(i) > 9 && Math.abs(i) < 100) {
        sum += i;
    }
}