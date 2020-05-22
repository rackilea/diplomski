for (int i =0 ; i < height; i++) {
        g.drawLine(gapBetweenFrameAndGrid, i * gapBetweenPoints
                + gapBetweenFrameAndGrid, gapBetweenFrameAndGrid+(width-1) * gapBetweenPoints, i
                * gapBetweenPoints + gapBetweenFrameAndGrid);
    }
    for (int i = 0; i < width; i++) {
        g.drawLine(i * gapBetweenPoints + gapBetweenFrameAndGrid,
                gapBetweenFrameAndGrid, i * gapBetweenPoints +  gapBetweenFrameAndGrid,
                gapBetweenFrameAndGrid+(height-1) * gapBetweenPoints);
    }