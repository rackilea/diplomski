private static void getBlockAverage(int startHeight, int endHeight, int startWidth, int endWidth, BufferedImage img, BufferedImage blockImg) {
    // break recursion on empty block
    if(endHeight <= startHeight || endWidth <= startWidth)
        return;

    if(startHeight + 1 == endHeight || startWidth + 1 == endWidth) {
        // work on single columns or rows of pixels
        // results are stored to blockImg...
    } else {
        // recurse
        getBlockAverage(startHeight, (startHeight + endHeight)/2, startWidth, (startWidth + endWidth)/2, img, blockImg);
        getBlockAverage((startHeight + endHeight)/2, endHeight, startWidth, (startWidth + endWidth)/2, img, blockImg);
        getBlockAverage(startHeight, (startHeight + endHeight)/2, (startWidth + endWidth)/2, endWidth, img, blockImg);
        getBlockAverage((startHeight + endHeight)/2, endHeight, (startWidth + endWidth)/2, endWidth, img, blockImg);
        // now collate the results in blockImg...
    }
}