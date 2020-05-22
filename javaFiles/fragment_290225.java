int intervalStart = a[0];
for (int i = 1; i < a.length; ++i) {
    if (a[i] > a[i-1] + 1) {
        outputInterval(intervalStart, a[i-1]);
        intervalStart = a[i];
    }
}
outputInterval(intervalStart, a[a.length-1]);