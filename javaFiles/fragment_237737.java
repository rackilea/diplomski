for (int j = 0; j < 3; j++) {
    xCoord[j] = generator.nextInt(maxCellWidth)
                    + (maxCellWidth * xMultiple);
    yCoord[j] = generator.nextInt(maxCellHeight)
                    + (maxCellHeight * yMultiple);
}