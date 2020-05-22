this.width = image.getWidth();
this.height = image.getHeight();

for (int row = 0; row < height; row++) {        // swapped the ...
    for (int col = 0; col < width; col++) {     // ... bounds
        this.PointInformation[row][col] = new Color(image.getRGB(col, row));
    }
}