public void simulateSong() {
    System.out.println("\nGuitar.simualateSong() ");
    for (int i = 0; i < chords; i++) {
        for (int j = 0; j < strings; j++) {
            System.out.printf(" %.2f", song[j][i]);
        }
        System.out.println();
    }
}