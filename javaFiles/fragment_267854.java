try {
  File f = new File ("/path/to/my/audio.mp3");
  DataSource ds = Manager.createDataSource(f.toURI().toURL());
  ds.connect();
  ds.start();
  ...
} catch (java.io.IOException e) {
  ...
} catch (NoDataSourceException e) {
  ...
}