class Stars {
    public static void main(String[] args) {
        int row, numberOfHashes;

        for (row = 1; row <= 6; row++) {
            for(numberOfBlanks = 1; numberOfBlanks <= 6 - row; numberOfBlanks++) {
                System.out.print("\t" + " ");
            }
            for(numberOfHashes = 1; numberOfHashes <= row; numberOfHashes++) {
                System.out.print("\t" + "#");
            }
            System.out.println(); // Go to next line
        }
    }
}