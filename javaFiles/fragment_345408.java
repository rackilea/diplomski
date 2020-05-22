private void reset() {  // no need to add the buttons again
    for (byte row = 0; row < 8; row++) {
        for (byte col = 0; col < 8; col++) {
            data[row][col] = icons[(byte) (Math.random() * icons.length)];
            shinyButtons[row][col].setIcon(data[row][col]);
        }
    }
}