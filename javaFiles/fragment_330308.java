public void writeToFile(AtomicLongMap<String>map, File file) throws IOException {
    HashMap<String, Long>newMap = new HashMap<>( map.asMap());

    try(FileOutputStream fout = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fout);) {

      oos.writeObject(newMap);

    }

  }