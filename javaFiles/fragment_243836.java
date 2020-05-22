File[] files = dir.listFiles(new FilenameFilter() {   
    @Override
    public boolean accept(File file, String name) {
        return !file.isDirectory();
    }
});
progressBar.setMaximum(files.length);
for (int i = 0; i < files.length; i++) {
    File f = files[i];
    try {
       unzipper.unzip(f.getAbsolutePath(), destDirectory, outputTextArea);
       progressBar.setValue(i);
       progressBar.update(progressBar.getGraphics());
   } catch (Exception ex) {
      ex.printStackTrace();
   }
}