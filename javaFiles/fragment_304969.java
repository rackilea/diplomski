public static int[] Separator1() {
    for(int i = 0; i < numbersGenerated.length; i++) {
        if (i % 2 == 0) { // Grabs even numbered indexes
            numberSet1[i / 2] = numbersGenerated[i]; // Places even numbered indexes
        }
    }
    return numberSet1;
}

public static int[] Separator2() {
    for (int i = 0; i < numbersGenerated.length; i++) {
        if (i % 2 != 0) { // Odd numbered indexes
            numberSet2[(i - 1) / 2] = numbersGenerated[i]; // Places odd numbered indexes
        }
    }
    return numberSet2;
}