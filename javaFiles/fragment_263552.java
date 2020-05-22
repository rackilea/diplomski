public void thinOutline() {
    boolean didThinIteration = false;
    for (int x = 1; x < originalWidth - 1; x++)
        for (int y = 1; y < originalHeight - 1; y++) {
            int numOfBorders = (thinned[x - 1][y] ? 1 : 0) + (thinned[x + 1][y] ? 1 : 0) + (thinned[x][y + 1] ? 1 : 0) + (thinned[x][y - 1] ? 1 : 0);
            int numOfDiagonals = (thinned[x - 1][y + 1] ? 1 : 0) + (thinned[x + 1][y + 1] ? 1 : 0) + (thinned[x - 1][y - 1] ? 1 : 0) + (thinned[x + 1][y - 1] ? 1 : 0);

            boolean thin = thinned[x][y] && numOfBorders > 1 && numOfBorders < 4 && numOfDiagonals > 1 && numOfDiagonals < 4;

            thinIteration[x][y] = thin;
            if (thin && !didThinIteration)
                didThinIteration = true;
        }

    for (int x = 0; x < originalWidth; x++)
        for (int y = 0; y < originalHeight; y++)
            if (thinIteration[x][y])
                thinned[x][y] = false;

    if (didThinIteration)
        thinOutline();
}