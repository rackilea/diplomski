public void printLog() throws IOException {
  final FileWriter w = new FileWriter("JServer_Log.txt", true);
  try {
    w.write(logTextArea.getText().replace("\n", 
                                    System.getProperty("line.separator")));
  } finally { w.close(); }
}