private void copyAssets() {
    AssetManager assetManager = getAssets();
    String[] files = null;
try {
    files = assetManager.list("");
} catch (IOException e) {
    Log.e("tag", "Failed to get asset file list.", e);
  }
 for(String filename : files) {
    InputStream in = null;
    OutputStream out = null;
    try {
      in = assetManager.open(filename);

      String outDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/X/Y/Z/" ; 

      File outFile = new File(outDir, filename);

      out = new FileOutputStream(outFile);
      copyFile(in, out);
      in.close();
      in = null;
      out.flush();
      out.close();
        out = null;
      } catch(IOException e) {
          Log.e("tag", "Failed to copy asset file: " + filename, e);
         }       
       }
     }
     private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
      int read;
     while((read = in.read(buffer)) != -1){
       out.write(buffer, 0, read);
     }
   }