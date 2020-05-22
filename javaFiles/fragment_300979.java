int trueCount = 0;
for (int i = 0; i < array.length; i++) {
    if (array.get(i) /* or array[i] */) {
        trueCount++;
    }
    if (trueCount >= 6) {
        break;
    }
}