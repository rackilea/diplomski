class InputStreamSplitter {
  InputStreamSplitter(InputStream toReadFrom) {
    this.reader = new InputStreamReader(toReadFrom);
  }
  void addListener(Listener l) {
    this.listeners.add(l);
  }
  void work() {
    String line = this.reader.readLine();
        while(line != null) {
      for(Listener l : this.listeners) {
        l.processLine(line);
      }
    }
  }
}

interface Listener {
  processLine(String line);
}