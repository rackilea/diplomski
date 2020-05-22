if (breakDown[i] % 2 == 1) {
        countOdd++;  
    }

    if (breakDown[i] % 2 == 0 && breakDown[i] != '0') {
        countEven++;
    }

    if (breakDown[i] == '0') {
        countZero++;
    }