int localStart = 0;
    int localEnd = end - start;
    Number[] local = new Number[5];
    tempMedianArray[0] = list[localStart + start];
    tempMedianArray[1] = list[(localStart + localEnd) / 4 + start];
    tempMedianArray[2] = list[(localStart + localEnd) / 4 * 3 + start];
    tempMedianArray[3] = list[(localStart + localEnd) / 2 + start];
    tempMedianArray[4] = list[localEnd + start];