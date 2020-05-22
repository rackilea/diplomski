MediaExtractor extractor = new MediaExtractor();
int frameRate = 24; //may be default
try {
  //Adjust data source as per the requirement if file, URI, etc.
  extractor.setDataSource(...);
  int numTracks = extractor.getTrackCount();
  for (int i = 0; i < numTracks; ++i) {
    MediaFormat format = extractor.getTrackFormat(i);
    String mime = format.getString(MediaFormat.KEY_MIME);
    if (mime.startsWith("video/")) {
    if (format.containsKey(MediaFormat.KEY_FRAME_RATE)) {
        frameRate = format.getInteger(MediaFormat.KEY_FRAME_RATE);
      }
    }
  }
} catch (IOException e) {
  e.printStackTrace();
}finally {
  //Release stuff
  extractor.release();
}