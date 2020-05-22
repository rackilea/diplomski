public void increaseAll(double[][] array, double amount) {
    for (double[] subArray : array) {
        for (int i = 0; i < subArray.length; i++) {
            subArray[i] += amount;
        }
    }
}