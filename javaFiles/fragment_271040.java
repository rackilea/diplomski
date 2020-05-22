public static void printArray(int[][] num1) {
    String output = "";
    for (int x = 0; x < num1.length; x++) {
        output += Arrays.toString(num1[x]) + "\n";
    }
    JOptionPane.showMessageDialog(null, output, "Uitvoer",
            JOptionPane.INFORMATION_MESSAGE);
}