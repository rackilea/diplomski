public static void main_broken(String[] args)
    throws IOException
{
    File geotiffFile = Paths.get("geotools-test.tiff").toFile();
    geotiffFile.deleteOnExit();
    GeoTiffReader reader = new GeoTiffReader(geotiffFile);
    GridCoverage2D result = reader.read(null);
    PlanarImage planarImage = (PlanarImage) result.getRenderedImage();
    ImageUtilities.disposePlanarImageChain(planarImage);
}