double maxValue = -1.0d;
int maxCount = 0;
for (int i = 0; i < data.length; ++i) {
    double currentValue = data[i];
    int currentCount = 1;
    for (int j = i + 1; j < data.length; ++j) {
        if (Math.abs(data[j] - currentValue) < epsilon) {
            ++currentCount;
        } 
    }
    if (currentCount > maxCount) {
        maxCount = currentCount;
        maxValue = currentValue;
    } else if (currentCount == maxCount) {
        maxValue = Double.NaN;
    }
}
System.out.println("mode: " + maxValue);