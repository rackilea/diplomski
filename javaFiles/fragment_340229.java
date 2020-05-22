public void printArray (ArrayList<Marker> marker) {

    // Create an array of chars, and make sure all values are set to '.'
    boolean[][] array = new char[t.length][t[h].length];
    for (int h=0; h < t.length; h++) {
        for (int w=0; w < t[h].length; w++) {
            array[h][w] = '.';
        }
    }

    // For each marker, set the value in the array at the marker's position to m
    for (Marker m: marker) {
        array[m.getY()][m.getX()] = 'm';
    }

    // Print the array
    for (int h=0; h<t.length; h++) {
        for (int w=0; w<t[h].length; w++) {
            System.out.print(array[h][w]);
        }
        System.out.println();
    }
}