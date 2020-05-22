for (int l = length; l > minLength; l--) {
    int amount = 1;
    for (int m = 0; m < length - l + 1; m++) { //there might be by 1 mistake
        amount *= filter[j - m - 1];
    }
    for (int m = 0; m < amount; m++) {
        System.out.print(l + " ");
    }
    System.out.println();
}