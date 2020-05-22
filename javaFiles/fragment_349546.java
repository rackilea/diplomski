for (int col = 0; col < data[0].length; col++) { // assuming all row have same length

    int large = data[0][col], 
        small = data[0][col];

    for (int row = 1; row < data.length; row++) {
        if (large < data[row][col]) {
            large = data[row][col];

        }
        if (small > data[row][col]) {
            small = data[row][col];
        }

    }
    System.out.println("\nlargest values:" + large);
    System.out.println("smallest values:" +small);
}