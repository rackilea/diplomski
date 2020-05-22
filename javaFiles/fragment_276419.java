// fills the priceArray with numbers from seatPrices.txt
private void start() {
    for (int i = 0; i < MAX_ROW; i++) {
        for (int j = 0; j <  MAX_COLUMN; j++) {
            try {
                if (scan.hasNextDouble()) {
                    priceArray[i][j] = scan.nextDouble();
                    System.out.println(":" + i + "," + j + " : " + priceArray[i][j]);
                }
            } catch (Exception e) {
                System.err.println("Error discovered at " + i + "," + j + ": " + e);
            }
        }
        if (scan.hasNextLine()) {
            scan.nextLine();
        }
    }
}