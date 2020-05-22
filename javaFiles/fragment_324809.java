int[] numbers = { 
    12, 8, 4, 13, 2, 7
};
boolean validation = true;
for (int i : numbers) {
    if (oposition == i) {
        validation = false;
        break;
    }
}