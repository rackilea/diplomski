int[] rssiValues = {20, 40, 45, 62, 85, 9, 12 };
int highest = rssiValues[0];
for (int index = 1; index < rssiValues.length; index ++) {
    if (rssiValues[index] > highest) {
        highest = rssiValues [index];
    }
}