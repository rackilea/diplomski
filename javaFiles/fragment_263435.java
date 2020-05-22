public static int getRowTotal(int[][] numbers, int index) {
            int total = 0;
            for (int y = 0; y < 3; y++) {
                total = total + numbers[index][y];
            }
            return total;
        }