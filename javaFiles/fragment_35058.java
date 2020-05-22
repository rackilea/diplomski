try {
  if(logWriter != null) {
    logWriter.close();
  }
} catch (IOException e1) {
    println("### Possible resource leak; unable to close log writer", Color.RED);
}