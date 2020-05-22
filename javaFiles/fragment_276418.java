private void start() {
    for (int i = 0; i < MAX_ROW; i++) {
        for (int j = 0; j <  MAX_COLUMN; j++) {
            try {
                priceArray[i][j] = scan.nextDouble();
            } catch (Exception e) {
                System.err.println("Error discovered at " + i + "," + j ": " + e);
            }
        }
    }
}