public static void main(String[] args) {
    double[][] array = new double[11][17];
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
            System.out.printf("[%d][%d]%n", i, j);
        }
    }
}