public void increaseAll(double[][] array, double amount) {
    for (int i = 0; i < array.length; i++) {             
        for (int j = 0; i < array[i].length; j++) {
            array[i][j] += amount;
        }
    }
}