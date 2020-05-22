for (int i =0 ; i < height; i++) {
        g.drawLine(startingX, i * gapBetweenPoints
                + gapBetweenFrameAndGrid, startingX+(width-1) * gapBetweenPoints, i
                * gapBetweenPoints + gapBetweenFrameAndGrid);
    }
    for (int i = 0; i < width; i++) {
        g.drawLine(i * gapBetweenPoints + gapBetweenFrameAndGrid,
                startingY, i * gapBetweenPoints +  gapBetweenFrameAndGrid,
                startingY+(height-1) * gapBetweenPoints);
    }