public class RasterToVector {

  public static void main(String[] args)
      throws IllegalArgumentException, IOException, InterruptedException, ExecutionException {
    RasterToVector rtv = new RasterToVector();

    SimpleFeatureCollection features = rtv.extract(args[0]);
    Style style = SLD.createPolygonStyle(Color.RED, null, 0.0f);
    Layer layer = new FeatureLayer(features, style);
    MapContent map = new MapContent();
    map.addLayer(layer);
    JMapFrame.showMap(map);
  }

  org.geotools.process.Process process;

  public RasterToVector() {
    Name name = new NameImpl("ras", "PolygonExtraction");
    process = Processors.createProcess(name);
  }

  private SimpleFeatureCollection extract(String filename)
      throws IllegalArgumentException, IOException, InterruptedException, ExecutionException {
    File rasterFile = new File(filename);
    AbstractGridFormat format = GridFormatFinder.findFormat(rasterFile);
    Hints hints = new Hints();
    if (format instanceof GeoTiffFormat) {
      hints = new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE);
    }
    AbstractGridCoverage2DReader reader = format.getReader(rasterFile, hints);
    GridCoverage2D coverage = reader.read(null);
    ProcessExecutor engine = Processors.newProcessExecutor(2);
    Map<String, Object> input = new KVP("data", coverage);
    Progress working = engine.submit(process, input);

    Map<String, Object> result = working.get();
    SimpleFeatureCollection features = (SimpleFeatureCollection) result.get("result");
    return features;
  }

}