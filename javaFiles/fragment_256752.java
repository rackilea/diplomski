private double similarityMeasure(BufferedImage leftRegion, BufferedImage rightRegion) {
    double ssd = 0;
    Raster left = leftRegion.getData();
    Raster right = rightRegion.getData();

    for(int x = 0; x < leftRegion.getWidth();  x++) {
        for(int y = 0; y < leftRegion.getHeight(); y++) {
            double diff = left.getSampleDouble(x,y,0) - right.getSampleDouble(x,y,0);
            ssd += diff*diff;
        }
    }
    return 1/ssd;
}