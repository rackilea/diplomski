BufferedImage img;
try {
    img = ImageIO.read(new File(path));
} catch (IOException e) {
    return null;
}

double[][] heightmap = new double[img.getWidth()][img.getHeight()];

WritableRaster raster = img.getRaster();

// Component size should be 8 or 16, yielding maxValue 255 or 65535 respectively
double maxValue = (1 << img.getColorModel().getComponentSize(0)) - 1;

for(int x = 0; x < heightmap.length; x++) {
    for(int y = 0; y < heightmap[0].length; y++) {
        heightmap[x][y] = raster.getSample(x, y, 0) / maxValue;
    }
}

return heightmap;