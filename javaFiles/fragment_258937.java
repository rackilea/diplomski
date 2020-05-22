private byte[][] mPrevieBuffers = new byte[4][];
@Override public void onPreviewFrame(byte[] data, Camera camera) {
  for (int i=0; i<mPreviewBuffers.length; i++) {
    if (data == mPreviewBuffers[i]) {
       processData(i);
    }
  }
}