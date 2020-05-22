public double calculateCopyPrice(int copies) {
    int[] range = { 99, 499, 749, 1000 };
    double copyPrice = 0;
    int index = -1;
    for (int i = 0; i < range.length; i++) {
        if (range[i] >= copies) {
            index = i;
            break;
        }
    }
    switch (index) {
        case 0: copyPrice = 0.30; break;
        case 1: copyPrice = 0.28; break;
        case 2: copyPrice = 0.27; break;
        case 3: copyPrice = 0.26; break;
        default: copyPrice = 0.25; break; 
    }
    //probably more logic here...
    return copyPrice;
}