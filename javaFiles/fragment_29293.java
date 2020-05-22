public void find(int row, int column) {
        int distance = 1;
        int numOfRows = arr.length;
        int numOfColumns = 0;
        if (arr.length > 0) {
            numOfColumns = arr[0].length;
        }
        int maxDistance = Math.max(numOfRows, numOfColumns);        
        for (distance = 1; distance < maxDistance; distance ++) {
            for (int i = Math.max(row - distance, 0); i <= Math.min(row + distance, numOfRows - 1); i++) {
                if (Math.abs(i - row) == distance) {
                    // Check row
                    for (int k = Math.max(column - distance, 0); k <= Math.min(column + distance, numOfColumns - 1); k++) {
                        if (arr[i][k] == null || arr[i][k].trim().isEmpty()) {
                            System.out.println((i+1) + "," + (k+1) + " is empty.");
                            return;
                        } else {
                            System.out.println((i+1) + "," + (k+1) + " is not empty.");
                        }
                    }
                } else {
                    // Check only edge elements
                    int k = column - distance;
                    if (k >= 0) {
                        if (arr[i][k] == null || arr[i][k].trim().isEmpty()) {
                            System.out.println((i+1) + "," + (k+1) + " is empty.");
                            return;
                        } else {
                            System.out.println((i+1) + "," + (k+1) + " is not empty.");
                        }
                    }
                    k = column + distance;
                    if (k < numOfColumns) {
                        if (arr[i][k] == null || arr[i][k].trim().isEmpty()) {
                            System.out.println((i+1) + "," + (k+1) + " is empty.");
                            return;
                        } else {
                            System.out.println((i+1) + "," + (k+1) + " is not empty.");
                        }
                    }
                }
            }
        }
        System.out.println("No empty elements");
    }