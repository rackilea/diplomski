Font f = new Font("Dialog", Font.PLAIN, 12); // choose a font for the numbers
g.setFont(f);

// Draw cell numbers
for (int x = 0; x < TOTAL_COLUMNS; x++) {
    for (int y = 0; y < TOTAL_ROWS; y++) {
        if (/* check if the (x,y) cell is uncovered */) {
            int around = minesAround(x, y);
            g.drawString(String.valueOf(around), /*cell x coord*/, /*cell y coord*/);
        }
    }
}