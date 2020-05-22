int row = 0;
    int col = 0;
    for (Image image : imageList) {
        grid.setWidget(row, col, image);
        col++;
        if (col > 2) {
            col = 0;
            row++;
        }
    }