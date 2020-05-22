int raiseMethod(int val, int pow) {

    int temp = val;
    for (int i = 1; i < pow; i++) {

        temp *= val;
    }
    return temp;
}

for (int i = 0; i < arrayColummns; i++) {

    for (int j = 0; j < arrayRows; j++) {

        array[i][j] = raiseMethod(array[i][j], powerToRaise);
    }
}