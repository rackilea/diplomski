Object[][] data = new Object[nb][3]; // nb rows, 3 columns
for (int row = 0; row < nb; row++) {
    data[row][0] = row + 1; // first column: row number
    data[row][1] = Math.random(100); // second column: weight
    data[row][2] = Math.random(10): // third column: priority
}