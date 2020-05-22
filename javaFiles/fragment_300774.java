public static void main(String[] args) {

    try (BufferedReader reader = new BufferedReader(new FileReader("c:\\temp\\text.txt"))) {

        int numberOfArrays = Integer.parseInt(reader.readLine());
        int[][] arrays = new int[numberOfArrays][];

        int i = 0;

        while (i < numberOfArrays) {
            String line = reader.readLine();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(" ");
            int[] lineNumbers = new int[parts.length - 1];

            // is "array id" really necessary? i am just ignoring it.

            for (int j = 0; j < lineNumbers.length; j++) {
                lineNumbers[j] = Integer.parseInt(parts[j + 1]);
            }

            arrays[i++] = lineNumbers;
        }

    } catch (IOException e) {
        throw new RuntimeException(e);
    }

}