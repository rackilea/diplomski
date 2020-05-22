static void write(Path path, Set<Name> names) throws IOException {
  try (OutputStream os = Files.newOutputStream(path);
       ObjectOutputStream oos = new ObjectOutputStream(os)) {
    oos.writeObject(names);    
  }       
} 

static Set<Name> read(Path path) throws IOException {
  try (InputStream is = Files.newInputStream(path);
       ObjectInputStream ois = new ObjectInputStream(is)) {
    // WARN Files.newInputStream is not buffered; ObjectInputStream might
    // be buffered (I don't remember).
    return (Set<Name>) ois.readObject();
  }
}